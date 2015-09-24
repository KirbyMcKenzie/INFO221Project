/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

import dao.OrderDAO;
import dao.OrderJdbcDAO;
import domain.Customer;
import domain.Order;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRResultSetDataSource;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;
import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

/**
 *
 * @author kirbymckenzie
 */
@WebServlet(name = "CheckoutServlet", urlPatterns = {"/CheckoutServlet"})
public class CheckoutServlet extends HttpServlet {

    private final OrderDAO dao = new OrderJdbcDAO();

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
            throws ServletException, IOException, SQLException, JRException, EmailException {
        response.setContentType("text/html;charset=UTF-8");
        
        // get customer from session
        HttpSession session = request.getSession();
        Customer cust = (Customer) session.getAttribute("customer");

        if (cust != null) {

            // process the sale
            Date currentDate = new Date();

            // set date and customer to order session
            Order order = (Order) session.getAttribute("order");
            order.setDate(currentDate);
            order.setCustomer(cust);
            session.setAttribute("order", order);
            
            //save the order
            dao.saveOrder(order);

            response.sendRedirect("/shop/Checkout.jsp");

            // -- CREATE THE REPORT -- 
            
            
            // get a connection to the database
            Connection con = DriverManager
                    .getConnection("jdbc:h2:tcp://localhost/~/project;IFEXISTS=TRUE", "sa", "");

            // select from the view
            String sql = "select * from ORDERITEMS";

            // execute the statement
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            // create the report using the result set as a data source
            JasperPrint report
                    = JasperFillManager.fillReport("/Users/kirbymckenzie/study/info221/orders.jasper/",
                            new HashMap<String, Object>(), new JRResultSetDataSource(rs)); // display the report
            JasperViewer.viewReport(report);

            // clean up
            stmt.close();
            con.close();

            // generate the pdf
            JasperExportManager.exportReportToPdfFile(report, "/Users/kirbymckenzie/study/info221/order.pdf/");

            
            /*
             // SEND THE REPORT - NOT FUCKING WORKING >:/
             Email email = new SimpleEmail();
             email.setHostName("localhost");
             email.setSmtpPort(2525);
             email.setFrom("disguised@unkown.sa");
             email.setSubject("Hey man");
             email.setMsg("Sup bruv");
             email.addTo("kirby.mckenzie@hotmail.com");
             email.send();
             */
            
            
        } else {

            // where to redirect?
            response.sendRedirect("/shop/Login.jsp");

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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(CheckoutServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (JRException ex) {
            Logger.getLogger(CheckoutServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (EmailException ex) {
            Logger.getLogger(CheckoutServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(CheckoutServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (JRException ex) {
            Logger.getLogger(CheckoutServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (EmailException ex) {
            Logger.getLogger(CheckoutServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
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

} // end CheckoutServlet class
