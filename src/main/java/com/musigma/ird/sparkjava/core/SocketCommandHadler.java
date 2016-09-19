package com.musigma.ird.sparkjava.core;

import com.musigma.ird.exception.JsonToObjectConvertionException;
import com.musigma.ird.utils.JsonObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author sudhir
 *         Date:19/9/16
 *         Time:11:24 AM
 *         Project:SparkJava
 */
public class SocketCommandHadler implements CommandHandler {
    private static final Logger LOGGER= LoggerFactory.getLogger(CommandHandler.class);
    private String socketInputString;
    @Override
    public String handleCommand() {
        SocketCommands receivedCommand=extractCommandFromJson();
        String responseTobeSent= handleThisCommad(receivedCommand);
        return responseTobeSent;
    }
    private SocketCommands extractCommandFromJson(){
        try{
            SocketDTO socketDTO=JsonObjectMapper.getInstanceFromJson(socketInputString,SocketDTO.class);
            return socketDTO.getSocketCommand();
        }catch(JsonToObjectConvertionException e){
            return SocketCommands.INVALID;
        }
    }
    private String handleThisCommad(SocketCommands command){
        switch (command){
            case LOAD_DATA_FRAME:{
                return  null;
            }
            case PERFORM_SQL_QUERY:{
                return null;
            }
            case INVALID:{
                return "Invalid Command received by Server";
            }
        }
    }
}