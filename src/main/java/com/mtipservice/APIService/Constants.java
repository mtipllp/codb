package com.mtipservice.APIService;

public class Constants {

	public static final String LOGGING_HEADER_USER_ID = "UserID";
	public static final String LOGGING_HEADER_SESSION_ID = "SessionId";
	public static final String LOGGING_HEADER_SERVICE_NAME = "Service";
	public static final String LOGGING_SERVICE_NAME = "APIService";
	public static final String LOGGING_HEADER_METHOD_ID = "MethodId";

	public static final String CONNECTION_TIMEOUT = "${connection.timeout}";

	public static final String SERVER_SSL_CERT_PATH = "${server.ssl.cert.path}";
	public static final String SERVER_SSL_TRUST_PATH = "${server.ssl.trust.path}";
	public static final String SERVER_SSL_CERT_PASSWORD = "${server.ssl.cert.password}";
	public static final String SERVER_SSL_TRUST_PASSWORD = "${server.ssl.trust.password}";

	public static final String CUSTOMERSERVICEURL = "${mtipservices.customerserviceurl}";
	public static final String ADDRESSSERVICEURL = "${mtipservices.addressserviceurl}";

	public static final String SERVER_KEYSTORE_PATH = "${server.keystore.path}";
	public static final String SERVER_KEYSTORE_ALIAS = "${server.keystore.alias}";
	public static final String SERVER_KEYSTORE_PASSWORD = "${server.keystore.password}";

	public static final String PCI_COMPLIANCE_FIELDS = "${pci.compliance.fields}";
	public static final int PRETTY_PRINT_INDENT_FACTOR = 4;

	public static final String BANK = "B";
	public static final String CREDIT = "C";
	public static final String PAPER = "P";
	public static final String DCC = "DCC";
	public static final String DEFT = "DEFT";
	public static final String INITIAL = "I";
	public static final String MONTHLY = "M";
	public static final String DELINQUENT = "D";
	public static final String CREDITCARD = "CREDIT CARD";
	public static final String BANKACCOUNT = "BANK ACCOUNT";
	public static final String PAPERBILL = "PAPER BILL";
	public static final String CASHONDELIVERY = "CASH ON DELIVERY";
	public static final String CASHORCHECK = "CASH OR CHECK";
	public static final String DCOC = "DCOC";
	public static final String COC = "DCOC";

	public static final String DD = "DD";
	public static final String D = "D";

}
