package listas;

import java.util.ArrayList;
import java.util.HashMap;

public class IngredientesHashMap {
  private HashMap<String, Integer> hashMap;

  public IngredientesHashMap() {
    this.hashMap = new HashMap<>();
  }

  public void criaIngrediente(String nome) {
    hashMap.put(nome.toLowerCase(), null);
  }

  public void usaIngrediente(String nome) {
    if (hashMap.containsKey(nome.toLowerCase())) {
      hashMap.put(nome.toLowerCase(), hashMap.get(nome) + 1);
    }
  }

  public void cancelarUsoDoIngrediente(String nome) {
    if (hashMap.containsKey(nome.toLowerCase())) {
      hashMap.put(nome.toLowerCase(), hashMap.get(nome) - 1);
    }
  }

  public String ingredienteToString(String nome) {
    return "Nome: " + nome.toLowerCase() + ", vezes utilizado: " + this.hashMap.get(nome.toLowerCase());
  }

  public String getMaisUsado() {
    int contador = 0;
    String maisUsado = "";

    for (var each : this.hashMap.entrySet()) {
      if(each.getValue() > contador) {
        contador = each.getValue();
        maisUsado = each.getKey();
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
}
