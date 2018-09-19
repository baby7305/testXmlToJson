import util.ResponseService;

import java.io.UnsupportedEncodingException;

public class Main {
	public static void main(String[] args) throws UnsupportedEncodingException {
		ResponseService responseService = new ResponseService();
		responseService.requestMgs();
	}
}
