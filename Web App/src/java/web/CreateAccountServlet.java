/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

import dao.CustomerDAO;
import dao.CustomerJdbcDAO;
import domain.Customer;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import net.sf.oval.ConstraintViolation;
import net.sf.oval.Validator;

/**
 *
 * @author kirbymckenzie
 */
@WebServlet(name = "CreateAccountServlet", urlPatterns = {"/CreateAccountServlet"})
public class CreateAccountServlet extends HttpServlet {

    Customer customer = new Customer();

    private final CustomerDAO dao = new CustomerJdbcDAO();
    
    //String validationMessage = 
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        
        String username = request.getParameter("username");
        String name = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String email = request.getParameter("email");
        String address = request.getParameter("streetAddress");
        String suburb = request.getParameter("suburb");
        String password = request.getParameter("password");

    
        customer.setUsername(username);
        customer.setFirstName(name);
        customer.setLastName(lastName);
        customer.setEmail(email);
        customer.setStreetAddress(address);
        customer.setSuburb(suburb);
        customer.setPassword(password);
        
        
         // create Oval validator
        Validator validator = new Validator();

        // validate the object
        List<ConstraintViolation> violations = validator.validate(customer);

        // were there any violations?
        if (violations.isEmpty()) {
            // nope
           dao.saveCustomer(customer);
           response.sendRedirect("/shop/");
           
        } else {
            // yes, so show constraint messages to user
            StringBuilder message = new StringBuilder();

            //	loop through the violations extracting the message for each
            for (ConstraintViolation violation : violations) {
                message.append(violation.getMessage()).append("\n");
            }

            // show a message box to the user with all the violation messages
            response.sendError(422, message.toString());

        }
        

        HttpSession session = request.getSession();
            session.setAttribute("customer", customer);
    }
    
        
    

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
    

}
    


