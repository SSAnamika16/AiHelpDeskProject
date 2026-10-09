package com.substring.helpdesk.service;


import com.substring.helpdesk.tools.TicketDatabaseTool;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.memory.ChatMemory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

@Getter
@Setter
@RequiredArgsConstructor
@Service
public class AiService {

    private final ChatClient chatClient;

    private final TicketDatabaseTool ticketDatabaseTool;

    @Value("classpath:/helpdesk-system.st")
    private Resource systemPromptResource;


    public String getResponseFromAssistant(String query, String userId) {

        //basic call to llm through chatclient
        return this.chatClient
                .prompt()
                .advisors(advisorSpec -> advisorSpec.param(ChatMemory.CONVERSATION_ID, userId))
                .tools(ticketDatabaseTool)
                .system(systemPromptResource)
                .user(query)
                .call()
                .content();

    }


}
