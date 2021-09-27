package br.com.alfashop.model;

/**
 *
 * @author alfamidia
 */
public class Produto 
{
    private Long    idproduto;
    private String  nome;
    private String  descricao;
    private String  maisinfo;
    private Float   peso;
    private Float   valor;
    private String  destaque;
    private String  ativo;
    private Long    catid;
    private String  catnome;

    /**
     * @return the idproduto
     */
    public Long getIdproduto() {
        return idproduto;
    }

    /**
     * @param idproduto the idproduto to set
     */
    public void setIdproduto(Long idproduto) {
        this.idproduto = idproduto;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the descricao
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * @param descricao the descricao to set
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    /**
     * @return the maisinfo
     */
    public String getMaisinfo() {
        return maisinfo;
    }

    /**
     * @param maisinfo the maisinfo to set
     */
    public void setMaisinfo(String maisinfo) {
        this.maisinfo = maisinfo;
    }

    /**
     * @return the peso
     */
    public Float getPeso() {
        return peso;
    }

    /**
     * @param peso the peso to set
     */
    public void setPeso(Float peso) {
        this.peso = peso;
    }

    /**
     * @return the valor
     */
    public Float getValor() {
        return valor;
    }

    /**
     * @param valor the valor to set
     */
    public void setValor(Float valor) {
        this.valor = valor;
    }

    /**
     * @return the destaque
     */
    public String getDestaque() {
        return destaque;
    }

    /**
     * @param destaque the destaque to set
     */
    public void setDestaque(String destaque) {
        this.destaque = destaque;
    }

    /**
     * @return the ativo
     */
    public String getAtivo() {
        return ativo;
    }

    /**
     * @param ativo the ativo to set
     */
    public void setAtivo(String ativo) {
        this.ativo = ativo;
    }

    /**
     * @return the catid
     */
    public Long getCatid() {
        return catid;
    }

    /**
     * @param catid the catid to set
     */
    public void setCatid(Long catid) {
        this.catid = catid;
    }

    /**
     * @return the catnome
     */
    public String getCatnome() {
        return catnome;
    }

    /**
     * @param catnome the catnome to set
     */
    public void setCatnome(String catnome) {
        this.catnome = catnome;
    }

    
    
}
