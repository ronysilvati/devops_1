/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package devops_1;

import devops_1.CalculadoraString;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author visitante
 */
public class CalculadoraStringTest {
    
    public CalculadoraStringTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    
    @Test
    public void testAdicionarFuncaoAdicionarSemParametros(){
        CalculadoraString cs = new CalculadoraString();
        
        
        assertEquals("0", cs.adicionar(""));
    }
    
    
    @Test
    public void testAdicionarFuncaoAdicionarUmParametro(){
        CalculadoraString cs = new CalculadoraString();
        
        
        assertEquals("2", cs.adicionar("2"));
    }
    
    @Test
    public void testAdicionarFuncaoAdicionarDoisParametros(){
        CalculadoraString cs = new CalculadoraString();
        
        
        assertEquals("5", cs.adicionar("2,3"));
    }
    
    @Test
    public void testAdicionarFuncaoAdicionarTresParametros(){
        CalculadoraString cs = new CalculadoraString();
        
        
        assertEquals("10", cs.adicionar("2,3,5"));
    }
    
    
    @Test
    public void testAdicionarFuncaoAdicionarQuatroParametros(){
        CalculadoraString cs = new CalculadoraString();
        
        
        assertEquals("20", cs.adicionar("2,3,5,10"));
    }
    
    @Test
    public void testAdicionarFuncaoAdicionarNovoSeparador(){
        CalculadoraString cs = new CalculadoraString();
        
        
        assertEquals("6", cs.adicionar("1\n2,3"));
    }
    
    @Test
    public void testAdicionarFuncaoAdicionarNovoSeparadorPosicaoErrada(){
        CalculadoraString cs = new CalculadoraString();
        
        
        assertEquals("\nNúmero esperado mas \\n encontrado na posição 2", cs.adicionar("1,\n3"));
    }
    
    @Test
    public void testAdicionarFuncaoAdicionarNumeroFaltando(){
        CalculadoraString cs = new CalculadoraString();
        
        
        assertEquals("\nNúmero esperado mas EOF encontrado", cs.adicionar("1,3,"));
    }
    
    @Test
    public void testAdicionarFuncaoAdicionarNovoDelimitador(){
        CalculadoraString cs = new CalculadoraString();
        
        
        assertEquals("3", cs.adicionar("//;\n1;2"));
    }
    
    
    @Test
    public void testAdicionarFuncaoAdicionarNovoDelimitador2(){
        CalculadoraString cs = new CalculadoraString();
        
        
        assertEquals("6", cs.adicionar("//|\n1|2|3"));
    }
    
    @Test
    public void testAdicionarFuncaoAdicionarNovoDelimitador3(){
        CalculadoraString cs = new CalculadoraString();
        
        
        assertEquals("6", cs.adicionar("//sep\n1sep2sep3"));
    }
    
    
    @Test
    public void testAdicionarFuncaoAdicionarNovoDelimitadorErradoPosicao(){
        CalculadoraString cs = new CalculadoraString();
        
        
        assertEquals("\n'|' esperado mas ',' encontrado na posição 3", cs.adicionar("//|\n1|2,3"));
    }
    
    
    @Test
    public void testAdicionarNegativos(){
        CalculadoraString cs = new CalculadoraString();
        
        
        assertEquals("\nNúmero negativo não permitido: -1", cs.adicionar("-1,2"));
    }
    
    
    @Test
    public void testAdicionarMultiplosErros(){
        CalculadoraString cs = new CalculadoraString();
        
        
        assertEquals("\nNúmero esperado mas , encontrado na posição 2\nNúmero negativo não permitido: -2", cs.adicionar("-2,,2"));
    }


    @Test
    public void testAdicionarNumerosGrandes(){
        CalculadoraString cs = new CalculadoraString();
        
        
        assertEquals("3", cs.adicionar("2,99123"));
    }


}