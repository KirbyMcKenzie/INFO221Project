/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import dao.DAOException;
import dao.ProductDAO;
import dao.ProductJdbcDAO;
import domain.Product;
import gui.helpers.SimpleListModel;
import gui.helpers.ValidationHelper;
import java.awt.Window;
import java.sql.SQLException;
import java.util.Collection;
import javax.swing.JOptionPane;
//import dao.ProductCollectionsDAO;

/**
 *
 * @author kirbymckenzie
 */
public class ProductEditor extends javax.swing.JDialog {

    //ProductCollectionsDAO dao = new ProductCollectionsDAO();
    private final ProductDAO dao;
    private final SimpleListModel myModel;
    private Collection<Product> productList;

    Product product = new Product();

    ValidationHelper validation = new ValidationHelper();

    //ProductJdbc dao = new ProductJdbcDAO();
    /**
     * Creates new form ProductAdmin
     */
    public ProductEditor(Window parent, boolean modal, ProductDAO dao) {
        super(parent);
        super.setModal(modal);
        this.dao = dao;
        initComponents();

        myModel = new SimpleListModel(dao.getAll());

        SimpleListModel myModelCategories = new SimpleListModel(dao.getCategories());

        productList = dao.getAll();

        cmbCategory.setEditable(true);
        cmbCategory.setModel(myModelCategories);

        validation.addTypeFormatter(txtPrice, "#0.00", Double.class);
        validation.addTypeFormatter(txtProductID, "00", Integer.class);
        validation.addTypeFormatter(txtQuantity, "0", Integer.class);

    }

    public ProductEditor(Window parent, boolean modal, Product productToEdit, ProductDAO dao) {
        // call other constructor
        this(parent, modal, dao);
        // assign the product we are editing to the product object
        this.product = productToEdit;

        //setting the details from selected product to edit
        txtProductID.setValue(this.product.getProductID());
        txtName.setText(String.valueOf(this.product.getName()));
        txtPrice.setValue(this.product.getPrice());
        txtQuantity.setValue(this.product.getQuantity());
        txtDescription.setText(String.valueOf(this.product.getDescription()));
        cmbCategory.setSelectedItem(String.valueOf(this.product.getCategory()));

        //making sure productID cannot be changed
        txtProductID.setEditable(false);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblProductID = new javax.swing.JLabel();
        lblName = new javax.swing.JLabel();
        lblDescription = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtDescription = new javax.swing.JTextArea();
        lblCategory = new javax.swing.JLabel();
        cmbCategory = new javax.swing.JComboBox();
        lblPrice = new javax.swing.JLabel();
        lblQuantity = new javax.swing.JLabel();
        btnSave = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txtProductID = new javax.swing.JFormattedTextField();
        txtName = new javax.swing.JFormattedTextField();
        txtPrice = new javax.swing.JFormattedTextField();
        txtQuantity = new javax.swing.JFormattedTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(700, 490));

        lblProductID.setForeground(new java.awt.Color(102, 102, 102));
        lblProductID.setText("Product ID:");

        lblName.setForeground(new java.awt.Color(102, 102, 102));
        lblName.setText("Name:");

        lblDescription.setForeground(new java.awt.Color(102, 102, 102));
        lblDescription.setText("Description:");

        jScrollPane1.setBackground(new java.awt.Color(204, 204, 204));

        txtDescription.setColumns(20);
        txtDescription.setForeground(new java.awt.Color(51, 51, 51));
        txtDescription.setRows(5);
        jScrollPane1.setViewportView(txtDescription);

        lblCategory.setForeground(new java.awt.Color(102, 102, 102));
        lblCategory.setText("Category Filter:");

        cmbCategory.setBackground(new java.awt.Color(204, 204, 204));
        cmbCategory.setForeground(new java.awt.Color(102, 102, 102));
        cmbCategory.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Bike", "Snow", "Watersports", "Outdoor", "Fishing" }));
        cmbCategory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbCategoryActionPerformed(evt);
            }
        });

        lblPrice.setForeground(new java.awt.Color(102, 102, 102));
        lblPrice.setText("Price:");

        lblQuantity.setForeground(new java.awt.Color(102, 102, 102));
        lblQuantity.setText("Quantity:");

        btnSave.setBackground(new java.awt.Color(204, 204, 204));
        btnSave.setForeground(new java.awt.Color(0, 153, 51));
        btnSave.setText("Save");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        btnCancel.setBackground(new java.awt.Color(204, 204, 204));
        btnCancel.setForeground(new java.awt.Color(102, 102, 102));
        btnCancel.setText("Cancel");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 0, 28)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 102, 102));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Product Editor ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(lblName, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblProductID, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(53, 53, 53)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtProductID)
                            .addComponent(txtName)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblPrice, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblQuantity, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE))
                        .addGap(53, 53, 53)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtPrice)
                            .addComponent(txtQuantity)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblCategory, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmbCategory, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(lblDescription, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 432, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblProductID)
                    .addComponent(txtProductID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblName)
                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPrice)
                    .addComponent(txtPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblQuantity)
                    .addComponent(txtQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCategory)
                    .addComponent(cmbCategory, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblDescription)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        try {
            Integer Id = (Integer) txtProductID.getValue();
            String name = txtName.getText();
            String description = txtDescription.getText();
            Double price = (Double) txtPrice.getValue();
            Integer quantity = (Integer) txtQuantity.getValue();
            String category = (String) cmbCategory.getSelectedItem();

            product.setProductID(Id);
            product.setName(name);
            product.setDescription(description);
            product.setPrice(price);
            product.setQuantity(quantity);
            product.setCategory(category);

            if (validation.isObjectValid(product)) {

                if (dao.getById(Integer.parseInt(txtProductID.getText())) == null) {
                    dao.saveProduct(product);
                    dispose();
                } else {
                    if (txtProductID.isEditable()) {
                        JOptionPane.showMessageDialog(this, "This ID already exists.");

                    } else {
                        dao.saveProduct(product);
                        myModel.updateItems(productList);
                        dispose();
                    }
                }
            }
        
    }catch (DAOException | NullPointerException ex) {
            JOptionPane.showMessageDialog(this, "All fields require input."
                    + " Please try again", "Invalid Input", JOptionPane.ERROR_MESSAGE);
            
    }



    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed

        dispose();

    }//GEN-LAST:event_btnCancelActionPerformed

    private void cmbCategoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbCategoryActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbCategoryActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnSave;
    private javax.swing.JComboBox cmbCategory;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblCategory;
    private javax.swing.JLabel lblDescription;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblPrice;
    private javax.swing.JLabel lblProductID;
    private javax.swing.JLabel lblQuantity;
    private javax.swing.JTextArea txtDescription;
    private javax.swing.JFormattedTextField txtName;
    private javax.swing.JFormattedTextField txtPrice;
    private javax.swing.JFormattedTextField txtProductID;
    private javax.swing.JFormattedTextField txtQuantity;
    // End of variables declaration//GEN-END:variables
}
