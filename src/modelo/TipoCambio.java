package modelo;

import java.util.Map;

public class TipoCambio {
    private String base;
    private Map<String, Double> results;
    private String updated;


    public TipoCambio() {
    }

    public TipoCambio(Map<String, Double> results) {
        this.results = results;
    }

    public TipoCambio(String base, Map<String, Double> results, String uspdated) {
        this.base = base;
        this.results = results;
        this.updated = uspdated;
    }

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public Map<String, Double> getResults() {
        return results;
    }

    public void setResults(Map<String, Double> results) {
        this.results = results;
    }

    public String getUpdated() {
        return updated;
    }

    public void setUpdated(String uspdated) {
        this.updated = uspdated;
    }

    @Override
    public String toString() {
        return "TipoDeCambio{" +
                "base='" + base + '\'' +
                ", results=" + results +
                ", uspdated='" + updated + '\'' +
                '}';
    }

}
