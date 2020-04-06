package urlpasing_utill;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

//문자속 URL 추출 및 확장 진행
public class URLExtract {
    private final String regex =
            // 도메인 명
            "(http://|https://|www)?((([A-Za-z\\d](([A-Za-z\\d-]*[A-Za-z\\d]))|([ㄱ-힣])*)\\.)+(([A-Za-z]{2,}))|"
            + "((\\d{1,3}\\.){3}\\d{1,3}))"// 아이피
            + "(\\:\\d+)?(\\/[A-Z-a-z\\d%_.~+]*)*" // 포트번호
            + "(\\?[;&a-z\\d%_.~+=-]*)?"// 쿼리스트링
            + "(\\#[-a-z\\d_]*)?"; // URL 추출 패턴 정규식

    public String url_ExtractSub(String msg) {
        StringBuilder stringBuilder = new StringBuilder();
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(msg);

        if (m.find()) {
            stringBuilder.append(m.group());
        }

        if (msg.contains("https://") || msg.contains("http://")) {
            return stringBuilder.toString();
        } else {
            // 프로토콜 없을 시 인위적 append
            if (msg.contains("hoy.kr")) {
                return "https://" + stringBuilder.toString();
            } else {
                return "http://" + stringBuilder.toString();
            }
        }
    }
}
