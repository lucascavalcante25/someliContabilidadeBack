package com.someli.someli.dto;

import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

public class SintegraDTO {

	@JsonProperty("code")
	private int code;

	@JsonProperty("code_message")
	private String codeMessage;

	@JsonProperty("header")
	private Header header;

	@JsonProperty("data_count")
	private int dataCount;

	@JsonProperty("data")
	private List<Data> data;

	@JsonProperty("errors")
	private List<String> errors;

	@JsonProperty("site_receipts")
	private List<String> siteReceipts;

	@JsonIgnoreProperties(ignoreUnknown = true)
	public static class Header {

		@JsonProperty("api_version")
		private String apiVersion;

		@JsonProperty("service")
		private String service;

		@JsonProperty("parameters")
		private Map<String, String> parameters;

		@JsonProperty("client_name")
		private String clientName;

		@JsonProperty("token_name")
		private String tokenName;

		@JsonProperty("billable")
		private boolean billable;

		@JsonProperty("price")
		private String price;

		@JsonProperty("requested_at")
		private String requestedAt;

		@JsonProperty("elapsed_time_in_milliseconds")
		private int elapsedTimeInMilliseconds;

		@JsonProperty("remote_ip")
		private String remoteIp;

		@JsonProperty("signature")
		private String signature;

		public String getApiVersion() {
			return apiVersion;
		}

		public void setApiVersion(String apiVersion) {
			this.apiVersion = apiVersion;
		}

		public String getService() {
			return service;
		}

		public void setService(String service) {
			this.service = service;
		}

		public Map<String, String> getParameters() {
			return parameters;
		}

		public void setParameters(Map<String, String> parameters) {
			this.parameters = parameters;
		}

		public String getClientName() {
			return clientName;
		}

		public void setClientName(String clientName) {
			this.clientName = clientName;
		}

		public String getTokenName() {
			return tokenName;
		}

		public void setTokenName(String tokenName) {
			this.tokenName = tokenName;
		}

		public boolean isBillable() {
			return billable;
		}

		public void setBillable(boolean billable) {
			this.billable = billable;
		}

		public String getPrice() {
			return price;
		}

		public void setPrice(String price) {
			this.price = price;
		}

		public String getRequestedAt() {
			return requestedAt;
		}

		public void setRequestedAt(String requestedAt) {
			this.requestedAt = requestedAt;
		}

		public int getElapsedTimeInMilliseconds() {
			return elapsedTimeInMilliseconds;
		}

		public void setElapsedTimeInMilliseconds(int elapsedTimeInMilliseconds) {
			this.elapsedTimeInMilliseconds = elapsedTimeInMilliseconds;
		}

		public String getRemoteIp() {
			return remoteIp;
		}

		public void setRemoteIp(String remoteIp) {
			this.remoteIp = remoteIp;
		}

		public String getSignature() {
			return signature;
		}

		public void setSignature(String signature) {
			this.signature = signature;
		}

	}

	public static class Data {

		@JsonProperty("abertura_data")
		private String aberturaData;

		@JsonProperty("atividade_economica")
		private String atividadeEconomica;

		@JsonProperty("atividade_economica_secundaria")
		private String atividadeEconomicaSecundaria;

		@JsonProperty("cnpj")
		private String cnpj;

		@JsonProperty("cnpj_cpf")
		private String cnpjCpf;

		@JsonProperty("consulta_data")
		private String consultaData;

		@JsonProperty("consulta_datahora")
		private String consultaDataHora;

		@JsonProperty("cpf")
		private String cpf;

		@JsonProperty("email")
		private String email;

		@JsonProperty("endereco_bairro")
		private String enderecoBairro;

		@JsonProperty("endereco_cep")
		private String enderecoCep;

		@JsonProperty("endereco_complemento")
		private String enderecoComplemento;

		@JsonProperty("endereco_logradouro")
		private String enderecoLogradouro;

		@JsonProperty("endereco_municipio")
		private String enderecoMunicipio;

		@JsonProperty("endereco_numero")
		private String enderecoNumero;

		@JsonProperty("endereco_uf")
		private String enderecoUf;

		@JsonProperty("inscricao_estadual")
		private String inscricaoEstadual;

		@JsonProperty("nome")
		private String nome;

		@JsonProperty("nome_fantasia")
		private String nomeFantasia;

		@JsonProperty("normalizado_abertura_data")
		private String normalizadoAberturaData;

		@JsonProperty("normalizado_cnpj")
		private String normalizadoCnpj;

		@JsonProperty("normalizado_cnpj_cpf")
		private String normalizadoCnpjCpf;

		@JsonProperty("normalizado_consulta_data")
		private String normalizadoConsultaData;

		@JsonProperty("normalizado_consulta_datahora")
		private String normalizadoConsultaDataHora;

		@JsonProperty("normalizado_cpf")
		private String normalizadoCpf;

		@JsonProperty("normalizado_endereco_cep")
		private String normalizadoEnderecoCep;

		@JsonProperty("normalizado_inscricao_estadual")
		private String normalizadoInscricaoEstadual;

		@JsonProperty("normalizado_situacao_cadastral_data")
		private String normalizadoSituacaoCadastralData;

		@JsonProperty("razao_social")
		private String razaoSocial;

		@JsonProperty("regime_apuracao")
		private String regimeApuracao;

		@JsonProperty("situacao_cadastral")
		private String situacaoCadastral;

		@JsonProperty("situacao_cadastral_data")
		private String situacaoCadastralData;

		@JsonProperty("telefone")
		private String telefone;

		@JsonProperty("site_receipt")
		private String siteReceipt;

		@JsonProperty("propriedade")
		private String propriedade;

		public String getPropriedade() {
			return propriedade;
		}

		public void setPropriedade(String propriedade) {
			this.propriedade = propriedade;
		}

		public String getNome() {
			return nome;
		}

		public void setNome(String nome) {
			this.nome = nome;
		}

		public String getAberturaData() {
			return aberturaData;
		}

		public void setAberturaData(String aberturaData) {
			this.aberturaData = aberturaData;
		}

		public String getAtividadeEconomica() {
			return atividadeEconomica;
		}

		public void setAtividadeEconomica(String atividadeEconomica) {
			this.atividadeEconomica = atividadeEconomica;
		}

		public String getAtividadeEconomicaSecundaria() {
			return atividadeEconomicaSecundaria;
		}

		public void setAtividadeEconomicaSecundaria(String atividadeEconomicaSecundaria) {
			this.atividadeEconomicaSecundaria = atividadeEconomicaSecundaria;
		}

		public String getCnpj() {
			return cnpj;
		}

		public void setCnpj(String cnpj) {
			this.cnpj = cnpj;
		}

		public String getCnpjCpf() {
			return cnpjCpf;
		}

		public void setCnpjCpf(String cnpjCpf) {
			this.cnpjCpf = cnpjCpf;
		}

		public String getConsultaData() {
			return consultaData;
		}

		public void setConsultaData(String consultaData) {
			this.consultaData = consultaData;
		}

		public String getConsultaDataHora() {
			return consultaDataHora;
		}

		public void setConsultaDataHora(String consultaDataHora) {
			this.consultaDataHora = consultaDataHora;
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

		public String getEnderecoBairro() {
			return enderecoBairro;
		}

		public void setEnderecoBairro(String enderecoBairro) {
			this.enderecoBairro = enderecoBairro;
		}

		public String getEnderecoCep() {
			return enderecoCep;
		}

		public void setEnderecoCep(String enderecoCep) {
			this.enderecoCep = enderecoCep;
		}

		public String getEnderecoComplemento() {
			return enderecoComplemento;
		}

		public void setEnderecoComplemento(String enderecoComplemento) {
			this.enderecoComplemento = enderecoComplemento;
		}

		public String getEnderecoLogradouro() {
			return enderecoLogradouro;
		}

		public void setEnderecoLogradouro(String enderecoLogradouro) {
			this.enderecoLogradouro = enderecoLogradouro;
		}

		public String getEnderecoMunicipio() {
			return enderecoMunicipio;
		}

		public void setEnderecoMunicipio(String enderecoMunicipio) {
			this.enderecoMunicipio = enderecoMunicipio;
		}

		public String getEnderecoNumero() {
			return enderecoNumero;
		}

		public void setEnderecoNumero(String enderecoNumero) {
			this.enderecoNumero = enderecoNumero;
		}

		public String getEnderecoUf() {
			return enderecoUf;
		}

		public void setEnderecoUf(String enderecoUf) {
			this.enderecoUf = enderecoUf;
		}

		public String getInscricaoEstadual() {
			return inscricaoEstadual;
		}

		public void setInscricaoEstadual(String inscricaoEstadual) {
			this.inscricaoEstadual = inscricaoEstadual;
		}

		public String getNomeFantasia() {
			return nomeFantasia;
		}

		public void setNomeFantasia(String nomeFantasia) {
			this.nomeFantasia = nomeFantasia;
		}

		public String getNormalizadoAberturaData() {
			return normalizadoAberturaData;
		}

		public void setNormalizadoAberturaData(String normalizadoAberturaData) {
			this.normalizadoAberturaData = normalizadoAberturaData;
		}

		public String getNormalizadoCnpj() {
			return normalizadoCnpj;
		}

		public void setNormalizadoCnpj(String normalizadoCnpj) {
			this.normalizadoCnpj = normalizadoCnpj;
		}

		public String getNormalizadoCnpjCpf() {
			return normalizadoCnpjCpf;
		}

		public void setNormalizadoCnpjCpf(String normalizadoCnpjCpf) {
			this.normalizadoCnpjCpf = normalizadoCnpjCpf;
		}

		public String getNormalizadoConsultaData() {
			return normalizadoConsultaData;
		}

		public void setNormalizadoConsultaData(String normalizadoConsultaData) {
			this.normalizadoConsultaData = normalizadoConsultaData;
		}

		public String getNormalizadoConsultaDataHora() {
			return normalizadoConsultaDataHora;
		}

		public void setNormalizadoConsultaDataHora(String normalizadoConsultaDataHora) {
			this.normalizadoConsultaDataHora = normalizadoConsultaDataHora;
		}

		public String getNormalizadoCpf() {
			return normalizadoCpf;
		}

		public void setNormalizadoCpf(String normalizadoCpf) {
			this.normalizadoCpf = normalizadoCpf;
		}

		public String getNormalizadoEnderecoCep() {
			return normalizadoEnderecoCep;
		}

		public void setNormalizadoEnderecoCep(String normalizadoEnderecoCep) {
			this.normalizadoEnderecoCep = normalizadoEnderecoCep;
		}

		public String getNormalizadoInscricaoEstadual() {
			return normalizadoInscricaoEstadual;
		}

		public void setNormalizadoInscricaoEstadual(String normalizadoInscricaoEstadual) {
			this.normalizadoInscricaoEstadual = normalizadoInscricaoEstadual;
		}

		public String getNormalizadoSituacaoCadastralData() {
			return normalizadoSituacaoCadastralData;
		}

		public void setNormalizadoSituacaoCadastralData(String normalizadoSituacaoCadastralData) {
			this.normalizadoSituacaoCadastralData = normalizadoSituacaoCadastralData;
		}

		public String getRazaoSocial() {
			return razaoSocial;
		}

		public void setRazaoSocial(String razaoSocial) {
			this.razaoSocial = razaoSocial;
		}

		public String getRegimeApuracao() {
			return regimeApuracao;
		}

		public void setRegimeApuracao(String regimeApuracao) {
			this.regimeApuracao = regimeApuracao;
		}

		public String getSituacaoCadastral() {
			return situacaoCadastral;
		}

		public void setSituacaoCadastral(String situacaoCadastral) {
			this.situacaoCadastral = situacaoCadastral;
		}

		public String getSituacaoCadastralData() {
			return situacaoCadastralData;
		}

		public void setSituacaoCadastralData(String situacaoCadastralData) {
			this.situacaoCadastralData = situacaoCadastralData;
		}

		public String getTelefone() {
			return telefone;
		}

		public void setTelefone(String telefone) {
			this.telefone = telefone;
		}

		public String getSiteReceipt() {
			return siteReceipt;
		}

		public void setSiteReceipt(String siteReceipt) {
			this.siteReceipt = siteReceipt;
		}

	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getCodeMessage() {
		return codeMessage;
	}

	public void setCodeMessage(String codeMessage) {
		this.codeMessage = codeMessage;
	}

	public Header getHeader() {
		return header;
	}

	public void setHeader(Header header) {
		this.header = header;
	}

	public int getDataCount() {
		return dataCount;
	}

	public void setDataCount(int dataCount) {
		this.dataCount = dataCount;
	}

	public List<Data> getData() {
		return data;
	}

	public void setData(List<Data> data) {
		this.data = data;
	}

	public List<String> getErrors() {
		return errors;
	}

	public void setErrors(List<String> errors) {
		this.errors = errors;
	}

	public List<String> getSiteReceipts() {
		return siteReceipts;
	}

	public void setSiteReceipts(List<String> siteReceipts) {
		this.siteReceipts = siteReceipts;
	}

}
