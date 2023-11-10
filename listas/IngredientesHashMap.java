package listas;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;
import java.util.stream.Collectors;
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
      hashMap.put(nome.toLowerCase(), hashMap.get(nome) + 1);
    }
  }

  public String ingredienteToString(String nome) {
    return "Nome: " + nome.toLowerCase() + ", vezes utilizado: " + this.hashMap.get(nome.toLowerCase());
  }

  public Entry<String, Integer> getMaisUsado() {
    int contador = Integer.MIN_VALUE;
    Entry<String, Integer> maisUsado = new AbstractMap.SimpleEntry<String, Integer>("", 0);

    for (var each : this.hashMap.entrySet()) {
      if(each.getValue() > contador) {
        contador = each.getValue();
        maisUsado = each;
      }
    }

    return maisUsado;
  }

  public String getNaoUsados() {
    ArrayList<String> naoUsados = new ArrayList<>();

    for (var each : this.hashMap.entrySet()) {
        if (each.getValue() == 0) {
          naoUsados.add(each.getKey());
        }
    }

    String result = naoUsados.stream().collect(Collectors.joining(", "));
    
    return result.substring(0, 1).toUpperCase() + result.substring(1);
  }

  public boolean contains(String ingrediente) {
    return this.hashMap.containsKey(ingrediente);
  }

  public Set<String> getKeys() {
    return this.hashMap.keySet();
  }
}
