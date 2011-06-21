/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.TesteDao;
import dao.TesteDaoImp;
import model.Teste;
import java.util.List;
import java.util.jar.Attributes.Name;
import javax.annotation.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

/**
 *
 * @author cyraax
 */
@ManagedBean
@SessionScoped
public class TesteController {
    private Teste teste;
    private DataModel listaTeste;
    
    public DataModel getListaTeste() {
        List<Teste> lista = new TesteDaoImp().list();
        listaTeste = new ListDataModel(lista);
        return listaTeste;
    }

    /**
     * @return the teste
     */
    public Teste getTeste() {
        return teste;
    }

    /**
     * @param teste the teste to set
     */
    public void setTeste(Teste teste) {
        this.teste = teste;
    }

    /**
     * @param listaTeste the listaTeste to set
     */
    public void setListaTeste(DataModel listaTeste) {
        this.listaTeste = listaTeste;
    }
    
    
    
    public String prepararAdicionarTeste(){
        teste = new Teste();
        return "gerenciarTeste";
    }

    public String prepararAlterarLivro(){
        teste = (Teste)(listaTeste.getRowData());
        return "gerenciarTeste";
    }

    public String excluirTeste(){

        Teste testeTemp = (Teste)(listaTeste.getRowData());
        TesteDao dao = new TesteDaoImp();
        dao.remove(testeTemp);
        return "index";

    }

    public String adicionarTeste(){

        TesteDao dao = new TesteDaoImp();
        dao.save(teste);
        return "index";
        
    }

    public String alterarTeste(){

        TesteDao dao = new TesteDaoImp();
        dao.update(teste);
        return "index";

    }
    
}
