package listas;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;
import java.util.Map.Entry;

public class IngredientesHashMap {
  private HashMap<String, Integer> hashMap;

  public IngredientesHashMap() {
    this.hashMap = new HashMap<>();
  }

  public void criarIngrediente(String nome) {
    hashMap.put(nome.toLowerCase(), 0);
  }

  public void usarIngredientes(ArrayList<String> nomes) {
    for (String nome : nomes) { 
      if (hashMap.containsKey(nome.toLowerCase())) {
        hashMap.put(nome.toLowerCase(), hashMap.get(nome) + 1);
      } 
    }
  }

  public String ingredienteToString(String nome) {
    return "Nome: " + nome.toLowerCase() + ", vezes utilizado: " + this.hashMap.get(nome.toLowerCase());
  }

  public Entry<String, Integer> getMaisUsado() {
    int contador = 0;
    Entry<String, Integer> maisUsado = new AbstractMap.SimpleEntry<String, Integer>("", 0);

    for (var each : this.hashMap.entrySet()) {
      if(each.getValue() > contador) {
        contador = each.getValue();
        maisUsado = each;
      }
    }

    return maisUsado;
  }

  public ArrayList<String> getNaoUsados() {
    ArrayList<String> naoUsados = new ArrayList<>();

    for (var each : this.hashMap.entrySet()) {
        if (each.getValue() == 0) {
          naoUsados.add(each.getKey());
        }
    }
    
    return naoUsados;
  }

  public boolean contains(String ingrediente) {
    return this.hashMap.containsKey(ingrediente);
  }

  public Set<String> getKeys() {
    return this.hashMap.keySet();
  }
}
