package util;

import webservice.MesEsbRequest;
import webservice.MesEsbResponse;
import webservice.MesEsbServiceImplService;

import java.io.UnsupportedEncodingException;

public class ResponseService {
	private MesEsbResponse lastReceivedResponse;
	private String FromId;
	private String passPort;
	private String bizType;

	public ResponseService() {
		this.FromId = "mj";
		this.passPort = "abc456";
		this.bizType = "mes_feature";
	}

	public MesEsbResponse requestMgs() throws UnsupportedEncodingException {
		String result;

		MesEsbRequest mesEsbRequest = new MesEsbRequest();
//        mesEsbRequest.setBizType("mes_feature");
		if (lastReceivedResponse != null) {
			mesEsbRequest.setResultEsbId(lastReceivedResponse.getEsbId());
			mesEsbRequest.setResultStatus(lastReceivedResponse.getResultStatus());
		} else {
			mesEsbRequest.setResultEsbId("");
			mesEsbRequest.setResultStatus("");
		}
		mesEsbRequest.setBizType(this.bizType);
		mesEsbRequest.setCompressionType("");
		mesEsbRequest.setDataContent(null);
		mesEsbRequest.setEncryptionType("");
		mesEsbRequest.setFromId(this.FromId);
		mesEsbRequest.setDestId("imesldv");
		mesEsbRequest.setHashCode("");
		mesEsbRequest.setPassport(this.passPort);
		mesEsbRequest.setPriority("3");
		mesEsbRequest.setRemark("");
		mesEsbRequest.setResultMsg("");
		mesEsbRequest.setTransportType("nop");
		mesEsbRequest.setSendDate(DateUtil.getCurrentDateStr());
		mesEsbRequest.setTokenCode("#TOKEN138a4d05e223f7959ddd16ac8bef2db1971f1fbb");
//        logger.info("Requesting... MesESb BOM Data used BizType={}", biztype);
		MesEsbServiceImplService esbServiceImplService = new MesEsbServiceImplService();
//		logger.info("Requesting MES ESB with {}.", mesEsbRequest.toString());
		if (this.bizType != null && !this.bizType.equals("")) {
			lastReceivedResponse = esbServiceImplService.getMesEsbServiceImplPort().dataSwitching(mesEsbRequest);
			if (lastReceivedResponse.getDataContent() != null) {
//                logger.info("MesESb Response DataContent :{}", new String(lastReceivedResponse.getDataContent(), "UTF-8"));
				result = new String(lastReceivedResponse.getDataContent(), "UTF-8");
				System.out.println(result);
				;
			} else {
//				logger.info("MesESb Response DataContent is null");
				result = "MesESb Response DataContent is null";
				System.out.println(result);
			}
		}
		return lastReceivedResponse;
	}
}
