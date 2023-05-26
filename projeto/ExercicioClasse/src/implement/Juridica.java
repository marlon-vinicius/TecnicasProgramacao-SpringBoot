package implement;

import java.util.Date;

public abstract class Juridica {
    private String cnpj;
    private String inscricaoEstadual;
    private Date nasc;
    
    public String getCnpj() {
        return cnpj;
    }
    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }
    public String getInscricaoEstadual() {
        return inscricaoEstadual;
    }
    public void setInscricaoEstadual(String inscricaoEstadual) {
        this.inscricaoEstadual = inscricaoEstadual;
    }
    public Date getNasc() {
        return nasc;
    }
    public void setNasc(Date nasc) {
        this.nasc = nasc;
    }
}
