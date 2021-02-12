package com.demopushnotification.example.service;

import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.demopushnotification.example.model.Mensagem;

@Service
public class NotificacoesPushImpl implements NotificacoesPush {

	@Value("${APP_ID}")
	private String APP_ID;

	@Value("${REST_API_KEY}")
	private String REST_API_KEY;

	@Value("${API_ONESIGNAL}")
	private String API_ONESIGNAL;;

	@Override
	public String enviar(Mensagem mensagem) {
		String jsonResponse;
		try {

			URL url = new URL(API_ONESIGNAL);
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			con.setUseCaches(false);
			con.setDoOutput(true);
			con.setDoInput(true);

			con.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
			con.setRequestProperty("Authorization", "Basic " + REST_API_KEY);// REST API
			con.setRequestMethod("POST");

			String strJsonBody = "{" + "\"app_id\": \"" + APP_ID + "\"," 
									 + "\"included_segments\": [\"All\"],"
					                 + "\"headings\": {\"en\": \"" + mensagem.getTitulo() + "\"}," 
					                 + "\"subtitle\": {\"en\": \"" + mensagem.getSubtitulo() + "\"},"
									 + "\"contents\": {\"en\": \"" + mensagem.getDescricao() + "\"}" 
					                 + "}";

			byte[] sendBytes = strJsonBody.getBytes("UTF-8");
			con.setFixedLengthStreamingMode(sendBytes.length);

			OutputStream outputStream = con.getOutputStream();
			outputStream.write(sendBytes);

			int httpResponse = con.getResponseCode();

			jsonResponse = String.valueOf(httpResponse);

		} catch (Throwable t) {
			jsonResponse = "500";
		}
		return jsonResponse;
	}


}
