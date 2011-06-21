/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import model.Teste;
import java.util.List;

/**
 *
 * @author José Alexandre
 */
public interface TesteDao {

    public void save(Teste teste);
    public Teste getTeste(long id);
    public List<Teste> list();
    public void remove(Teste teste);
    public void update(Teste teste);

}
