package arch;
import java.util.*;
import javax.swing.JDialog;
import javax.swing.table.DefaultTableModel;
 
public class gui extends javax.swing.JFrame {

    /* Creates new form gui */
    public gui() {
        initComponents();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        count = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        input = new javax.swing.JTextArea();
        nextinstruc = new javax.swing.JButton();
        allcode = new javax.swing.JButton();
        regs = new javax.swing.JScrollPane();
        registers = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        memory = new javax.swing.JTable();
        clear = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel2.setText("Program Counter:");

        count.setText("0");

        jLabel1.setText("Enter Assembly code:");

        input.setColumns(20);
        input.setRows(5);
        jScrollPane1.setViewportView(input);

        nextinstruc.setText("execute Next instruction");
        nextinstruc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextinstrucActionPerformed(evt);
            }
        });

        allcode.setText("execute All code");
        allcode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                allcodeActionPerformed(evt);
            }
        });

        registers.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Register-Name", "R-Number", "R-Vlaue"
            }
        ));
        regs.setViewportView(registers);

        memory.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"0x00000094", null},
                {"0x00000090", null},
                {"0x0000008C", null},
                {"0x00000088", null},
                {"0x00000084", null},
                {"0x00000080", null},
                {"0x0000007C", null},
                {"0x00000078", null},
                {"0x00000074", null},
                {"0x00000070", null},
                {"0x0000006C", null},
                {"0x00000068", null},
                {"0x00000064", null},
                {"0x00000060", null},
                {"0x0000005C", null},
                {"0x00000058", null},
                {"0x00000054", null},
                {"0x00000050", null},
                {"0x0000004C", null},
                {"0x00000048", null},
                {"0x00000044", null},
                {"0x00000040", null},
                {"0x0000003C", null},
                {"0x00000038", null},
                {"0x00000034", null},
                {"0x00000030", null},
                {"0x0000002C", null},
                {"0x00000028", null},
                {"0x00000024", null},
                {"0x00000020", null},
                {"0x0000001C", null},
                {"0x00000018", null},
                {"0x00000014", null},
                {"0x00000010", null},
                {"0x0000000C", null},
                {"0x00000008", null},
                {"0x00000004", null},
                {"0x00000000", null}
            },
            new String [] {
                "Memory Adresses", "Values"
            }
        ));
        jScrollPane3.setViewportView(memory);

        clear.setText("Clear");
        clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(16, 16, 16)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel2)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(count, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(352, 352, 352)
                            .addComponent(clear, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(regs, javax.swing.GroupLayout.PREFERRED_SIZE, 345, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 345, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(allcode)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(nextinstruc)))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(count))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(clear)))
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(regs, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 453, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(allcode)
                    .addComponent(nextinstruc))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    static int pc=0;
    static boolean beg=true;
    private void nextinstrucActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextinstrucActionPerformed
        try{
            String input, counter;
            implementation I= new implementation();
            
            input=this.input.getText();
            counter=this.count.getText();
            
            if( !beg && pc == I.p.code.size()){
                System.out.println("Error!, can't take an Input");
                //reset
                I.p.code.clear();
                I.mem_val.clear();
                I.storedc=0;
                I.instc=0;
                pc=0;
                return; 
            }
            
            I.implementation(input,counter);
            this.count.setText(String.valueOf(++pc));
            addreg(I.reg, I.reg_val);
            addmemo(I.mem, I.mem_val);
            beg=false;

        }catch(Exception e){
            System.out.println("Error, can't take an Input");
            return;
        }
    }//GEN-LAST:event_nextinstrucActionPerformed

    private void allcodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_allcodeActionPerformed
        try{
            //start=true;
            String input;
            implementation I= new implementation();
            input=this.input.getText();
            I.implementation(input,null);
            this.count.setText(String.valueOf(I.p.code.size()));
                       
            addreg(I.reg, I.reg_val);
            addmemo(I.mem, I.mem_val);
            
            I.p.code.clear(); //reset
            I.mem_val.clear();
            I.storedc=0;
            I.instc=0;
            beg=false;
            
        }catch(Exception e){
            System.out.println("Error, can't take an Input");
            return;
        }
    }//GEN-LAST:event_allcodeActionPerformed

    private void clearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearActionPerformed
       this.input.setText("");
       this.count.setText("0");
       implementation I= new implementation();
       I.regs(); 
       I.mem();
       addreg(I.reg, I.reg_val);
       addmemo(I.mem, I.mem_val);
       beg=true;
    }//GEN-LAST:event_clearActionPerformed
        
    public void addreg(Vector reg, Vector value){
        DefaultTableModel model = (DefaultTableModel)registers.getModel();
        model.setRowCount(0);
        for(int i=0; i<reg.size();i++){
            Object[] row = new Object[3];
            row[0]=String.valueOf(reg.get(i));
            row[1]=i;
            row[2]=Integer.parseInt(String.valueOf(value.get(i)));
            model.addRow(row);       
            registers.setModel(model);
        }
    }
    
    public void addmemo(Vector mem, Vector value){
        DefaultTableModel model = (DefaultTableModel)memory.getModel();
        model.setRowCount(0);
        for(int i=0; i<mem.size();i++){
            Object[] row = new Object[2];
            row[0]=String.valueOf(mem.get(i));
            row[1]=String.valueOf(value.get(i));
            model.addRow(row);       
            memory.setModel(model);
        }
    }
  
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(gui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(gui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(gui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(gui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run(){
                new gui().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton allcode;
    private javax.swing.JButton clear;
    private javax.swing.JLabel count;
    private javax.swing.JTextArea input;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable memory;
    private javax.swing.JButton nextinstruc;
    private javax.swing.JTable registers;
    private javax.swing.JScrollPane regs;
    // End of variables declaration//GEN-END:variables

}