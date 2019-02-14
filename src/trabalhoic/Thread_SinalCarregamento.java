/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhoic;

import javax.swing.JButton;

/**
 *
 * @author SoldierJVX
 */
public class Thread_SinalCarregamento extends Thread {

    FormTela formTela;

    public Thread_SinalCarregamento(FormTela formTela) {
        this.formTela = formTela;
    }

    @Override
    public void run() {
        
        JButton btnCarregar = formTela.getBtnCarregarArquivo();

        while (true) {

            try {

                btnCarregar.setText("Carregando");
                Thread.sleep(500);

                btnCarregar.setText("Carregando.");
                Thread.sleep(500);

                btnCarregar.setText("Carregando..");
                Thread.sleep(500);

                btnCarregar.setText("Carregando...");
                Thread.sleep(500);
            } catch (InterruptedException ex) {
                System.err.println(ex.getMessage());
            }

        }

    }

}
