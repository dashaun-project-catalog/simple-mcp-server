package dev.dashaun.mcp.datetime;

import org.springaicommunity.mcp.annotation.McpTool;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
class DateTimeService {

    @McpTool(description = "Get the current date and time in the user's timezone")
    String getCurrentDateTime() {
        return LocalDateTime.now().atZone(LocaleContextHolder.getTimeZone().toZoneId()).toString();
    }

}