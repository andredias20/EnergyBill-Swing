/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author andre
 */
public final class EnergyBill {

    private Integer id;
    private String nome;
    private Date data_nascimento;
    private String cpf;
    private String email;
    private String endereco;
    private String cep;
    private String sexo;
    private Integer unidade_consumidora;
    private Date data_vencimento;
    private Double consumo_kv;
    private Double custo_kv;
    private Double valor_total;

    public EnergyBill() {
    }

    public EnergyBill(int id, String nome, Date data_nascimento, String cpf, String email, String endereco, String cep, String sexo, Integer unidade_consumidora, Date data_vencimento, Double consumo_kv, Double custo_kv) {
        setId(id);
        setNome(nome);
        setData_nascimento(data_nascimento);
        setCpf(cpf);
        setEmail(email);
        setEndereco(endereco);
        setCep(cep);
        setSexo(sexo);
        setUnidade_consumidora(unidade_consumidora);
        setData_vencimento(data_vencimento);
        setConsumo_kv(consumo_kv);
        setCusto_kv(custo_kv);
        setValor_total();
    }

    public boolean validBill() {
        boolean result = true;

        if (this.nome == null || this.nome.length() < 2) {
            String message = "O nome digitado é inválido\n O valor '" + this.nome + "'é inválido";
            if (this.nome.length() < 2) {
                message += "\nO nome deve ter ao menos 3 digitos";
            }
            JOptionPane.showMessageDialog(null, message, "ERROR", JOptionPane.ERROR_MESSAGE);
            result = false;
        }
        if (this.data_nascimento == null) {
            String message = "A data indicada é inválido\n O valor '" + this.data_nascimento + "'é inválido";
            JOptionPane.showMessageDialog(null, message, "ERROR", JOptionPane.ERROR_MESSAGE);
            result = false;
        }
        if (this.data_vencimento == null) {
            String message = "A data indicada é inválido\n O valor '" + this.data_vencimento + "'é inválido";
            JOptionPane.showMessageDialog(null, message, "ERROR", JOptionPane.ERROR_MESSAGE);
            result = false;
        }
        if (this.cpf == null || this.cpf == "") {
            String message = "O CPF indicada é inválido\n O valor '" + this.cpf + "'é inválido";
            JOptionPane.showMessageDialog(null, message, "ERROR", JOptionPane.ERROR_MESSAGE);
            result = false;
        }
        if (this.email == null || this.email == "") {
            String message = "O email indicado é inválido\n O valor '" + this.email + "'é inválido";
            JOptionPane.showMessageDialog(null, message, "ERROR", JOptionPane.ERROR_MESSAGE);
            result = false;
        }
        if (this.endereco == null || this.endereco == "") {
            String message = "O endereço indicado é inválido\n O valor '" + this.endereco + "'é inválido";
            JOptionPane.showMessageDialog(null, message, "ERROR", JOptionPane.ERROR_MESSAGE);
            result = false;
        }
        if (this.cep == null || this.cep == "") {
            String message = "O CEP indicado é inválido\n O valor '" + this.cep + "'é inválido";
            JOptionPane.showMessageDialog(null, message, "ERROR", JOptionPane.ERROR_MESSAGE);
            result = false;
        }
        if (this.sexo == null || this.sexo == "") {
            String message = "O Sexo indicado é inválido\n O valor '" + this.sexo + "'é inválido";
            JOptionPane.showMessageDialog(null, message, "ERROR", JOptionPane.ERROR_MESSAGE);
            result = false;
        }
        if (this.unidade_consumidora == null || this.unidade_consumidora < 1) {
            String message = "A unidade consumidora indicada é inválido\n O valor '" + this.unidade_consumidora + "'é inválido";
            JOptionPane.showMessageDialog(null, message, "ERROR", JOptionPane.ERROR_MESSAGE);
            result = false;
        }
        if (this.consumo_kv == null || this.consumo_kv < 1) {
            String message = "O Consumo indicado é inválido\n O valor '" + this.consumo_kv + "'é inválido";
            JOptionPane.showMessageDialog(null, message, "ERROR", JOptionPane.ERROR_MESSAGE);
            result = false;
        }
        if (this.custo_kv == null || this.custo_kv < 0.01) {
            String message = "O Custo indicado é inválido\n O valor '" + this.custo_kv + "'é inválido";
            JOptionPane.showMessageDialog(null, message, "ERROR", JOptionPane.ERROR_MESSAGE);
            result = false;
        }
        if (this.valor_total == null || this.valor_total < 1.00) {
            String message = "O Valor Total indicado é inválido\n O valor '" + this.unidade_consumidora + "'é inválido";
            JOptionPane.showMessageDialog(null, message, "ERROR", JOptionPane.ERROR_MESSAGE);
            result = false;
        }

        return result;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getData_nascimento() {
        return data_nascimento;
    }

    public void setData_nascimento(Date data_nascimento) {
        this.data_nascimento = data_nascimento;
    }

    public void setData_nascimento(String data_nascimento) {
        if (data_nascimento != null && data_nascimento.length() > 2) {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            try {
                this.data_nascimento = sdf.parse(data_nascimento);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        } else {
            this.data_vencimento = null;
        }
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String Sexo) {
        this.sexo = Sexo;
    }

    public int getUnidade_consumidora() {
        return unidade_consumidora;
    }

    public void setUnidade_consumidora(int unidade_consumidora) {
        this.unidade_consumidora = unidade_consumidora;
    }

    public void setUnidade_consumidora(String num) {
        if (num.length() > 0) {
            this.unidade_consumidora = Integer.parseInt(num);
        }
    }

    public Date getData_vencimento() {
        return data_vencimento;
    }

    public void setData_vencimento(Date data_vencimento) {
        this.data_vencimento = data_vencimento;
    }

    public void setData_vencimento(String data_vencimento) {
        if (data_vencimento != null && data_vencimento.length() > 2) {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            try {
                this.data_vencimento = sdf.parse(data_vencimento);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        } else {
            this.data_vencimento = null;
        }

    }

    public Double getConsumo_kv() {
        return consumo_kv;
    }

    public void setConsumo_kv(Double consumo_kv) {
        this.consumo_kv = consumo_kv;
    }

    public void setConsumo_kv(String num) {
        if (num.length() > 0) {
            this.consumo_kv = Double.parseDouble(num);
        } else {
            this.consumo_kv = null;
        }
    }

    public double getCusto_kv() {
        return custo_kv;
    }

    public void setCusto_kv(double custo_kv) {
        this.custo_kv = custo_kv;
        this.setValor_total();
    }

    public void setCusto_kv(String num) {
        if (num.length() > 0) {
            this.consumo_kv = Double.parseDouble(num);
        } else {
            this.consumo_kv = null;
        }
        this.setValor_total();
    }

    public double getValor_total() {
        return valor_total;
    }

    public void setValor_total() {
        if (this.consumo_kv != null && this.custo_kv != null) {
            if (this.consumo_kv > 0 && this.custo_kv > 0) {
                this.valor_total = (double) this.consumo_kv * this.custo_kv;
            } else {
                this.valor_total = null;
            }
        }
    }

    @Override
    public String toString() {
        return "EnergyBill{" + "id=" + id + ", nome=" + nome + ", data_nascimento=" + data_nascimento + ", cpf=" + cpf + ", email=" + email + ", endereco=" + endereco + ", cep=" + cep + ", Sexo=" + sexo + ", unidade_consumidora=" + unidade_consumidora + ", data_vencimento=" + data_vencimento + ", consumo_kv=" + consumo_kv + ", custo_kv=" + custo_kv + ", valor_total=" + valor_total + '}';
    }

}
