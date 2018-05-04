/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java;

/**
 *
 * @author visitante
 */
public class CalculadoraString {

    public CalculadoraString() {

    }

    public String adicionar(String numero) {
        String valorRetornado = numero;
        String[] valoresDaAdicao;
        int somaValores = 0;
        String delimitadorOriginal = ",";
        String delimitadorTemp = "_";
        String mensagemSistema = "";
        String mensagemNegativos = "";

        if (numero == "") {
            valorRetornado = "0";
        } else {
            if ((numero.length() > 5) && numero.substring(0, 2).equals("//")) {

                delimitadorOriginal = this.getDelimitador(numero);
                numero = numero.replace("//" + delimitadorOriginal + "\n", "");

                if (delimitadorOriginal.equals("|")) {
                    numero = numero.replace(delimitadorOriginal, delimitadorTemp);
                } else {
                    delimitadorTemp = delimitadorOriginal;
                }
            } else {
                delimitadorTemp = delimitadorOriginal;
            }

            if (numero.substring(numero.length() - 1).equals(delimitadorTemp)) {
                return "\nNúmero esperado mas EOF encontrado";
            }

            if ((delimitadorTemp != ",") && (numero.indexOf(",") > -1)) {
                mensagemSistema += "\n'" + delimitadorOriginal + "' esperado mas ',' encontrado na posição " + (numero.indexOf(","));
                valorRetornado = mensagemSistema;
            } else {

                if (numero.indexOf(delimitadorTemp + delimitadorTemp) > -1) {
                    mensagemSistema += "\nNúmero esperado mas " + delimitadorTemp + " encontrado na posição " + (numero.indexOf(delimitadorTemp + delimitadorTemp));
                }

                if (numero.indexOf(delimitadorTemp + "\n") > -1) {
                    mensagemSistema += "\nNúmero esperado mas \\n encontrado na posição " + (numero.indexOf(delimitadorTemp + "\n") + 1);
                    valorRetornado = mensagemSistema;
                } else {

                    valoresDaAdicao = numero.split(delimitadorTemp + "|\n");

                    for (String valorAdicao : valoresDaAdicao) {

                        if (!valorAdicao.isEmpty()) {

                            if (Integer.parseInt(valorAdicao) < 0) {

                                if (mensagemNegativos != "") {
                                    mensagemNegativos += ", ";
                                }

                                mensagemNegativos += valorAdicao;

                            } else if (Integer.parseInt(valorAdicao) < 9999) {
                                somaValores += Integer.parseInt(valorAdicao);
                            }
                        }

                    }

                    if (mensagemNegativos != "") {
                        mensagemSistema += "\nNúmero negativo não permitido: " + mensagemNegativos;
                        valorRetornado = mensagemSistema;
                    } else {
                        valorRetornado = Integer.toString(somaValores);
                    }
                }

            }

            
        }
        
        return valorRetornado;
    }

    protected String getDelimitador(String numero) {
        int indexQuebraLinha = numero.indexOf('\n');
        return numero.substring(2, indexQuebraLinha);
    }

}
