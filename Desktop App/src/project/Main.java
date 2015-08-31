/*
 * To change this license header, choose License Headers in Main Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import dao.ProductDAO;
import dao.ProductJdbcDAO;
import gui.MainMenu;

/**
 *
 * @author kirbymckenzie
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
         final ProductDAO dao = new ProductJdbcDAO();

        MainMenu frame = new MainMenu(dao);

        // centre the frame on the screen
        frame.setLocationRelativeTo(null);

        // show the frame
        frame.setVisible(true);

    }

}
