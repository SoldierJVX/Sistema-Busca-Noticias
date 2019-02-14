/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhoic;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author SoldierJVX
 */
public class ManipulacaoDados {

    public static void recuperarDados(FormTela tela) {

        ArrayList<URL> listaUrls = tela.listaUrls;
        HashMap<String, ArrayList<URL>> hashListaUrls = tela.hashListaUrls;

        String texto = "";
        String[] separador = null;
        listaUrls.clear();

        try {
            BufferedReader buf = new BufferedReader(new FileReader(tela.escolherArquivo.getSelectedFile()));

            boolean sair = false;
            while (!sair) {
                texto = buf.readLine();

                if (texto == null) {
                    sair = true;
                } else {

                    separador = texto.split("\t");

                    separador[0] = separador[0].replace("&amp;nbsp;", "");
                    separador[0] = separador[0].replace("&lt;br&gt;", "");

                    if (separador.length == 2 && !separador[0].equals("") && !separador[1].equals("")) {
                        listaUrls.add(new URL(separador[0], separador[1]));

                        separador[0] = separador[0].toLowerCase();
                        separador[0] = separador[0].replace(".", "");
                        separador[0] = separador[0].replace(",", "");
                        separador[0] = separador[0].replace("?", "");
                        separador[0] = separador[0].replace("(", "");
                        separador[0] = separador[0].replace(")", "");
                        separador[0] = separador[0].replace("\\", "");
                        separador[0] = separador[0].replace("!", "");
                        separador[0] = separador[0].replace(";", "");
                        separador[0] = separador[0].replace("'", "");
                        separador[0] = separador[0].replace("\"", "");

                        String[] termosTitulo = separador[0].split(" ");

                        for (int i = 0; i < termosTitulo.length; i++) {
                            if (hashListaUrls.containsKey(termosTitulo[i])) {
                                hashListaUrls.get(termosTitulo[i]).add(listaUrls.get(listaUrls.size() - 1));
                            } else {
                                ArrayList<URL> termosMapa = new ArrayList<>();
                                termosMapa.add(listaUrls.get(listaUrls.size() - 1));
                                hashListaUrls.put(termosTitulo[i], termosMapa);
                            }
                        }

                        separador[0] = separador[0].replaceAll("[ãáàâ]+", "a");
                        separador[0] = separador[0].replaceAll("[éèê]+", "e");
                        separador[0] = separador[0].replaceAll("[íìî]+", "i");
                        separador[0] = separador[0].replaceAll("[óòôõ]+", "o");
                        separador[0] = separador[0].replaceAll("[úùû]+", "u");
                        separador[0] = separador[0].replaceAll("ç+", "c");

                        termosTitulo = separador[0].split(" ");

                        for (int i = 0; i < termosTitulo.length; i++) {
                            if (hashListaUrls.containsKey(termosTitulo[i])) {
                                hashListaUrls.get(termosTitulo[i]).add(listaUrls.get(listaUrls.size() - 1));
                            } else {
                                ArrayList<URL> termosMapa = new ArrayList<>();
                                termosMapa.add(listaUrls.get(listaUrls.size() - 1));
                                hashListaUrls.put(termosTitulo[i], termosMapa);
                            }
                        }

                    }
                }
            }

            buf.close();
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Erro - Tente Novamente", "Erro", JOptionPane.ERROR_MESSAGE);
        }

    }

    public static void pesquisaAnd(FormTela formTela) {
        long clockNano = System.nanoTime();
        long clockMili = System.currentTimeMillis();

        HashMap<String, ArrayList<URL>> hashListaUrls = formTela.hashListaUrls;
        HashMap<String, URL> hashPaginasAExibir = new HashMap<>();

        String[] buscandoTermos;

        int possuiTodosOsTermos = 0;

        String txtPesquisa = formTela.getTxtPesquisa().getText().toLowerCase().trim();
        String[] partesPesquisa = txtPesquisa.split(" ");

        buscandoTermos = new String[partesPesquisa.length];

        for (int i = 0; i < partesPesquisa.length; i++) {
            buscandoTermos[i] = partesPesquisa[i];
        }

        for (int i = 0; i < partesPesquisa.length; i++) {

            if (hashListaUrls.containsKey(partesPesquisa[i])) {

                ArrayList<URL> possiveisURLS = hashListaUrls.get(partesPesquisa[i]);
                for (int j = 0; j < possiveisURLS.size(); j++) {

                    String titulo = possiveisURLS.get(j).getTitulo().toLowerCase();
                    String[] termosDados = titulo.split(" ");
                    for (int k = 0; k < termosDados.length; k++) {

                        String parteDados = termosDados[k];
                        parteDados.replace(",", "");
                        parteDados.replaceAll("[\\.\\?\\(\\)\\\\,!;'\\\"]+", "");

                        for (int l = 0; l < buscandoTermos.length; l++) {

                            if (buscandoTermos[l] != null) {

                                if (parteDados.matches(buscandoTermos[l])) {
                                    possuiTodosOsTermos++;
                                    buscandoTermos[l] = null;
                                }
                                break;

                            }

                        }

                        if (possuiTodosOsTermos == partesPesquisa.length) {
                            hashPaginasAExibir.put(titulo, possiveisURLS.get(j));
                            break;
                        }

                    }

                    for (int k = 0; k < partesPesquisa.length; k++) {
                        buscandoTermos[k] = partesPesquisa[k];
                    }

                    possuiTodosOsTermos = 0;
                }
            }
        }

        processarDadosaExibir(hashPaginasAExibir, clockMili, clockNano);
    }

    public static void pesquisaOr(FormTela formTela) {

        long clockNano = System.nanoTime();
        long clockMili = System.currentTimeMillis();

        HashMap<String, ArrayList<URL>> hashListaUrls = formTela.hashListaUrls;
        HashMap<String, URL> hashPaginasAExibir = new HashMap<>();

        String txtPesquisa = formTela.getTxtPesquisa().getText().toLowerCase().trim();
        String[] termosPesquisa = txtPesquisa.split(" ");

        for (int i = 0; i < termosPesquisa.length; i++) {

            if (hashListaUrls.containsKey(termosPesquisa[i])) {

                ArrayList<URL> paginas = hashListaUrls.get(termosPesquisa[i]);
                for (int j = 0; j < paginas.size(); j++) {
                    hashPaginasAExibir.put(paginas.get(j).getTitulo(), paginas.get(j));
                }

            }

        }

        processarDadosaExibir(hashPaginasAExibir, clockMili, clockNano);

    }

    public static void exibirTodosDados(FormTela formTela) {
        new FormResultado(formTela.listaUrls);
    }

    private static void processarDadosaExibir(HashMap<String, URL> hashPaginas, long clockMili, long clockNano) {

        ArrayList<URL> paginasAExibir = new ArrayList<>();

        Set<String> key = hashPaginas.keySet();
        Iterator<String> iterator = key.iterator();

        while (iterator.hasNext()) {
            String chave = iterator.next();
            paginasAExibir.add(hashPaginas.get(chave));
        }

        organizarColecao(paginasAExibir);

        long fimMili = System.currentTimeMillis() - clockMili;
        long fimNano = System.nanoTime() - clockNano;

        System.out.println("Tempo de execução: " + fimMili + " milisegundo(s) = " + fimNano + " nanosegundo(s)");

        // 1 milisegundo = 1000000 nanosegundos
        if (paginasAExibir.size() == 0) {
            JOptionPane.showMessageDialog(null, "Sem Resultados!", "Sem Resultados", JOptionPane.INFORMATION_MESSAGE);
        } else {
            new FormResultado(paginasAExibir);
        }
    }

    public static void organizarColecao(ArrayList<URL> listaAOrdernar) {
        Collections.sort(listaAOrdernar);
    }

}
