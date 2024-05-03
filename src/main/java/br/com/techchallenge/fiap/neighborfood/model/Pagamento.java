package br.com.techchallenge.fiap.neighborfood.model;

import java.util.Objects;

public class Pagamento {

    private Long idPedido;
    private Boolean pagou = false;

    public Pagamento() {
    }

    public Pagamento(Long idPedido, Boolean pagou) {
        this.idPedido = idPedido;
        this.pagou = pagou;
    }

    public Long getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(Long idPedido) {
        this.idPedido = idPedido;
    }

    public Boolean getPagou() {
        return pagou;
    }

    public void setPagou(Boolean pagou) {
        this.pagou = pagou;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Pagamento pagamento)) return false;
        return Objects.equals(idPedido, pagamento.idPedido) && Objects.equals(pagou, pagamento.pagou);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idPedido, pagou);
    }

    @Override
    public String toString() {
        return "Pagamento{" +
                "idPedido=" + idPedido +
                ", pagou=" + pagou +
                '}';
    }
}
