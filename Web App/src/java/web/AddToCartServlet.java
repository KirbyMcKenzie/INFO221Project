/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

import domain.Order;
import domain.OrderItem;
import domain.Product;
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
 * 
 */
@WebServlet(name = "AddToCartServlet", urlPatterns = {"/AddToCartServlet"})
public class AddToCartServlet extends HttpServlet {

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
        
        HttpSession session = request.getSession();
        
        // get product from session
        Product product = (Product) session.getAttribute("product");
        
        // get quantity number wanted by user
        String prodQuantity = request.getParameter("quantity");
         Integer quantity = Integer.parseInt(prodQuantity);
         
         // store in OrderItem object
         OrderItem orderItem = new OrderItem(quantity, product.getPrice(), product);
         
         // get order from session
         Order order = (Order) session.getAttribute("order");
         
         // add item to order object
         order.addItem(orderItem);
         
         
         //remove product from session
         session.removeAttribute("product");

         
         // create Oval validator
        Validator validator = new Validator();

        // validate the object
        List<ConstraintViolation> violations = validator.validate(order);

        // were there any violations?
        if (violations.isEmpty()) {
            
            // to the cart
        response.sendRedirect("/shop/ShoppingCart.jsp");
           
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
 
        
    } // end processRequest method

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

} // end AddToCartServlet
