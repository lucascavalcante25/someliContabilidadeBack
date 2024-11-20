package com.someli.someli.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CnpjResponseDTO {

	@JsonProperty("status")
	private String status;

	@JsonProperty("ultima_atualizacao")
	private String ultimaAtualizacao;

	@JsonProperty("cnpj")
	private String cnpj;

	@JsonProperty("tipo")
	private String tipo;

	@JsonProperty("porte")
	private String porte;

	@JsonProperty("nome")
	private String nome;

	@JsonProperty("fantasia")
	private String fantasia;

	@JsonProperty("abertura")
	private String abertura;

	@JsonProperty("atividade_principal")
	private List<Atividade> atividadePrincipal;

	@JsonProperty("atividades_secundarias")
	private List<Atividade> atividadesSecundarias;

	@JsonProperty("natureza_juridica")
	private String naturezaJuridica;

	@JsonProperty("logradouro")
	private String logradouro;

	@JsonProperty("numero")
	private String numero;

	@JsonProperty("complemento")
	private String complemento;

	@JsonProperty("cep")
	private String cep;

	@JsonProperty("bairro")
	private String bairro;

	@JsonProperty("municipio")
	private String municipio;

	@JsonProperty("uf")
	private String uf;

	@JsonProperty("email")
	private String email;

	@JsonProperty("telefone")
	private String telefone;

	@JsonProperty("efr")
	private String efr;

	@JsonProperty("situacao")
	private String situacao;

	@JsonProperty("data_situacao")
	private String dataSituacao;

	@JsonProperty("motivo_situacao")
	private String motivoSituacao;

	@JsonProperty("situacao_especial")
	private String situacaoEspecial;

	@JsonProperty("data_situacao_especial")
	private String dataSituacaoEspecial;

	@JsonProperty("capital_social")
	private String capitalSocial;

	@JsonProperty("qsa")
	private List<Socio> qsa;

	@JsonProperty("simples")
	private Simples simples;

	@JsonProperty("simei")
	private Simei simei;

	@JsonProperty("billing")
	private Billing billing;


	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getUltimaAtualizacao() {
		return ultimaAtualizacao;
	}

	public void setUltimaAtualizacao(String ultimaAtualizacao) {
		this.ultimaAtualizacao = ultimaAtualizacao;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getPorte() {
		return porte;
	}

	public void setPorte(String porte) {
		this.porte = porte;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getFantasia() {
		return fantasia;
	}

	public void setFantasia(String fantasia) {
		this.fantasia = fantasia;
	}

	public String getAbertura() {
		return abertura;
	}

	public void setAbertura(String abertura) {
		this.abertura = abertura;
	}

	public List<Atividade> getAtividadePrincipal() {
		return atividadePrincipal;
	}

	public void setAtividadePrincipal(List<Atividade> atividadePrincipal) {
		this.atividadePrincipal = atividadePrincipal;
	}

	public List<Atividade> getAtividadesSecundarias() {
		return atividadesSecundarias;
	}

	public void setAtividadesSecundarias(List<Atividade> atividadesSecundarias) {
		this.atividadesSecundarias = atividadesSecundarias;
	}

	public String getNaturezaJuridica() {
		return naturezaJuridica;
	}

	public void setNaturezaJuridica(String naturezaJuridica) {
		this.naturezaJuridica = naturezaJuridica;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getMunicipio() {
		return municipio;
	}

	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEfr() {
		return efr;
	}

	public void setEfr(String efr) {
		this.efr = efr;
	}

	public String getSituacao() {
		return situacao;
	}

	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}

	public String getDataSituacao() {
		return dataSituacao;
	}

	public void setDataSituacao(String dataSituacao) {
		this.dataSituacao = dataSituacao;
	}

	public String getMotivoSituacao() {
		return motivoSituacao;
	}

	public void setMotivoSituacao(String motivoSituacao) {
		this.motivoSituacao = motivoSituacao;
	}

	public String getSituacaoEspecial() {
		return situacaoEspecial;
	}

	public void setSituacaoEspecial(String situacaoEspecial) {
		this.situacaoEspecial = situacaoEspecial;
	}

	public String getDataSituacaoEspecial() {
		return dataSituacaoEspecial;
	}

	public void setDataSituacaoEspecial(String dataSituacaoEspecial) {
		this.dataSituacaoEspecial = dataSituacaoEspecial;
	}

	public String getCapitalSocial() {
		return capitalSocial;
	}

	public void setCapitalSocial(String capitalSocial) {
		this.capitalSocial = capitalSocial;
	}

	public List<Socio> getQsa() {
		return qsa;
	}

	public void setQsa(List<Socio> qsa) {
		this.qsa = qsa;
	}

	public Simples getSimples() {
		return simples;
	}

	public void setSimples(Simples simples) {
		this.simples = simples;
	}

	public Simei getSimei() {
		return simei;
	}

	public void setSimei(Simei simei) {
		this.simei = simei;
	}

	public Billing getBilling() {
		return billing;
	}

	public void setBilling(Billing billing) {
		this.billing = billing;
	}

	public static class Atividade {
		public String getCode() {
			return code;
		}

		public void setCode(String code) {
			this.code = code;
		}

		public String getText() {
			return text;
		}

		public void setText(String text) {
			this.text = text;
		}

		@JsonProperty("code")
		private String code;

		@JsonProperty("text")
		private String text;

	}

	public static class Socio {
		@JsonProperty("nome")
		private String nome;

		@JsonProperty("qual")
		private String qual;

		@JsonProperty("pais_origem")
		private String paisOrigem;

		@JsonProperty("nome_rep_legal")
		private String nomeRepLegal;

		@JsonProperty("qual_rep_legal")
		private String qualRepLegal;

		public String getNome() {
			return nome;
		}

		public void setNome(String nome) {
			this.nome = nome;
		}

		public String getQual() {
			return qual;
		}

		public void setQual(String qual) {
			this.qual = qual;
		}

		public String getPaisOrigem() {
			return paisOrigem;
		}

		public void setPaisOrigem(String paisOrigem) {
			this.paisOrigem = paisOrigem;
		}

		public String getNomeRepLegal() {
			return nomeRepLegal;
		}

		public void setNomeRepLegal(String nomeRepLegal) {
			this.nomeRepLegal = nomeRepLegal;
		}

		public String getQualRepLegal() {
			return qualRepLegal;
		}

		public void setQualRepLegal(String qualRepLegal) {
			this.qualRepLegal = qualRepLegal;
		}

	}

	public static class Simples {
		@JsonProperty("optante")
		private boolean optante;

		@JsonProperty("data_opcao")
		private String dataOpcao;

		@JsonProperty("data_exclusao")
		private String dataExclusao;

		@JsonProperty("ultima_atualizacao")
		private String ultimaAtualizacao;

		public boolean isOptante() {
			return optante;
		}

		public void setOptante(boolean optante) {
			this.optante = optante;
		}

		public String getDataOpcao() {
			return dataOpcao;
		}

		public void setDataOpcao(String dataOpcao) {
			this.dataOpcao = dataOpcao;
		}

		public String getDataExclusao() {
			return dataExclusao;
		}

		public void setDataExclusao(String dataExclusao) {
			this.dataExclusao = dataExclusao;
		}

		public String getUltimaAtualizacao() {
			return ultimaAtualizacao;
		}

		public void setUltimaAtualizacao(String ultimaAtualizacao) {
			this.ultimaAtualizacao = ultimaAtualizacao;
		}

	}

	public static class Simei {
		@JsonProperty("optante")
		private boolean optante;

		@JsonProperty("data_opcao")
		private String dataOpcao;

		@JsonProperty("data_exclusao")
		private String dataExclusao;

		@JsonProperty("ultima_atualizacao")
		private String ultimaAtualizacao;

		public boolean isOptante() {
			return optante;
		}

		public void setOptante(boolean optante) {
			this.optante = optante;
		}

		public String getDataOpcao() {
			return dataOpcao;
		}

		public void setDataOpcao(String dataOpcao) {
			this.dataOpcao = dataOpcao;
		}

		public String getDataExclusao() {
			return dataExclusao;
		}

		public void setDataExclusao(String dataExclusao) {
			this.dataExclusao = dataExclusao;
		}

		public String getUltimaAtualizacao() {
			return ultimaAtualizacao;
		}

		public void setUltimaAtualizacao(String ultimaAtualizacao) {
			this.ultimaAtualizacao = ultimaAtualizacao;
		}

	}

	public static class Billing {
		@JsonProperty("free")
		private boolean free;

		@JsonProperty("database")
		private boolean database;

		public boolean isFree() {
			return free;
		}

		public void setFree(boolean free) {
			this.free = free;
		}

		public boolean isDatabase() {
			return database;
		}

		public void setDatabase(boolean database) {
			this.database = database;
		}

	}
}
