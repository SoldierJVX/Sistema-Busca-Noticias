/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhoic;

/**
 *
 * @author SoldierJVX
 */
public class URL implements Comparable<URL> {

    private String titulo;
    private String url;

    public URL(String titulo, String url) {
        this.titulo = titulo;
        this.url = url;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getUrl() {
        return url;
    }

    @Override
    public int compareTo(URL o) {
        return this.titulo.compareTo(o.titulo);
    }

}
