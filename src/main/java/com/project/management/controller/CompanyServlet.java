package com.project.management.controller;

import com.project.management.domain.Company;
import com.project.management.domainDAO.CompanyDAO;
import com.project.management.utils.ActionValidator;
import com.project.management.utils.EntityValidator;
import com.project.management.utils.ErrorMessage;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Locale;
import java.util.Objects;


@WebServlet(urlPatterns = "/company/*")
public class CompanyServlet extends HttpServlet {
    private CompanyDAO companyDAO;

    @Override
    public void init() throws ServletException {
        super.init();
        companyDAO = new CompanyDAO();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = ActionValidator.getAction(req);
        if (action.startsWith("/findCompany")) {
            req.getRequestDispatcher("/view/company/find_company.jsp").forward(req, resp);

        }
        if (action.startsWith("/createCompany")) {
            req.setAttribute("message", "Date Format is: dd-mmm-yyyy");
            req.getRequestDispatcher("/view/company/create_company.jsp").forward(req, resp);
        }
        if (action.startsWith("/deleteCompany")) {
            req.getRequestDispatcher("/view/company/delete_company.jsp").forward(req, resp);
        }
        if (action.startsWith("/allCompanies")) {
            List<Company> companies = companyDAO.getAll();
            System.out.println(companies.get(0));
            req.setAttribute("companies", companies);
            System.out.println(companies.get(1));
            req.getRequestDispatcher("/view/company/all_companies.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = ActionValidator.getAction(req);
        if (action.startsWith("/createCompany")) {
            try {
                Company company = mapCompany(req);
                List<ErrorMessage> errorMessages = validateCompany(company);
                if (!errorMessages.isEmpty()) {
                    req.setAttribute("errors", errorMessages);
                    req.getRequestDispatcher("/view/company/create_company.jsp").forward(req, resp);
                } else {
                    companyDAO.create(company);
                    req.setAttribute("message", "New Company created: " + company);
                }
            } catch (IllegalArgumentException e) {
                req.setAttribute("message", e.getMessage());
            }
            req.getRequestDispatcher("/view/company/create_company.jsp").forward(req, resp);

        }

        if (action.startsWith("/findCompany")) {
            final String id = req.getParameter("id").trim();
            final Company company = companyDAO.read(Integer.parseInt(id));
            if (company == null) {
                req.setAttribute("message", "Company not found");
                req.getRequestDispatcher("/view/company/find_company.jsp").forward(req, resp);
            } else {
                req.setAttribute("message", String.format("Company found: %s", company));
                req.getRequestDispatcher("/view/company/find_company.jsp").forward(req, resp);
            }
        }
        if (action.startsWith("/deleteCompany")) {
            int id = Integer.parseInt(req.getParameter("id"));
            if (companyDAO.read(id) == null) {
                req.setAttribute("message", "Company not found");
            } else {
                companyDAO.delete(companyDAO.read(id));
                req.setAttribute("message", String.format("Company with ID=%s deleted", id));
            }
            req.getRequestDispatcher("/view/company/delete_company.jsp").forward(req, resp);
        }

    }

    private Company mapCompany(HttpServletRequest req) {
        try {
            final String companyName = req.getParameter("title").trim();
            DateTimeFormatter df = new DateTimeFormatterBuilder()
                    .parseCaseInsensitive()
                    .appendPattern("dd-MMM-yyyy")
                    .toFormatter(Locale.ENGLISH);
            final LocalDate startDate = LocalDate.parse(req.getParameter("date"), df);
            return new Company(companyName, startDate);
        } catch (
                DateTimeParseException e) {
            throw new IllegalArgumentException("Date Format should be: dd-mmm-yyyy");
        }
    }

    private List<ErrorMessage> validateCompany(Company company) {
        final List<ErrorMessage> errorMessages = EntityValidator.validateEntity(company);
        final Company persistentCompany = companyDAO.findByName(company.getName());
        if (Objects.nonNull(persistentCompany) && !persistentCompany.getName().isEmpty()) {
            errorMessages.add(new ErrorMessage("", "Company with this title already exists"));
        }
        return errorMessages;
    }
}
