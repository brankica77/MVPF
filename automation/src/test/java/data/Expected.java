package data;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.JsonParseException;

import java.io.File;
import java.io.IOException;

public class Expected {

    @JsonProperty("INPUT_PAGE")
    InputPage inputPage;

    @JsonProperty("ALERT_PAGE")
    AlertPage alertPage;

    @JsonProperty("LIST_BOX_PAGE")
    ListBoxPage listBoxPage;

    static class InputPage{
        @JsonProperty("EMPTY_FIRST_NAME")
        String empty_first_name;

        @JsonProperty("EMPTY_LAST_NAME")
        String empty_last_name;

        @JsonProperty("EMPTY_EMAIL")
        String empty_email;

        @JsonProperty("EMPTY_PHONE")
        String empty_phone;

        @JsonProperty("EMPTY_ADDRESS")
        String empty_address;

        @JsonProperty("EMPTY_CITY")
        String empty_city;

        @JsonProperty("EMPTY_STATE")
        String empty_state;

        @JsonProperty("EMPTY_ZIP_CODE")
        String empty_zip_code;

        @JsonProperty("EMPTY_PROJECT_DESC")
        String empty_project_desc;
    }

    static class AlertPage{
        @JsonProperty("AUTOCLOSEABLE_SUCCESS_MESSAGE")
        String autocloseable_success_message;

        @JsonProperty("NORMAL_SUCCESS_MESSAGE")
        String normal_success_message;

        @JsonProperty("AUTOCLOSEABLE_WARNING_MESSAGE")
        String autocloseable_warning_message;

        @JsonProperty("NORMAL_WARNING_MESSAGE")
        String normal_warning_message;

        @JsonProperty("AUTOCLOSEABLE_DANGER_MESSAGE")
        String autocloseable_danger_message;

        @JsonProperty("NORMAL_DANGER_MESSAGE")
        String normal_danger_message;

        @JsonProperty("AUTOCLOSEABLE_INFO_MESSAGE")
        String autocloseable_info_message;

        @JsonProperty("NORMAL_INFO_MESSAGE")
        String normal_info_message;
    }

    static class ListBoxPage{
        @JsonProperty("LEFT_ITEM_1")
        String left_item_1;

        @JsonProperty("RIGHT_ITEM_1")
        String right_item_1;

        @JsonProperty("ITEM")
        String item;
    }

    public static Expected get(String filename) throws JsonParseException, JsonMappingException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(new File(filename), Expected.class);
    }

    public String getEmptyFirstNameError(){
        return inputPage.empty_first_name;
    }

    public String getEmptyLastNameError(){
        return inputPage.empty_last_name;
    }

    public String getEmptyEmailError(){
        return inputPage.empty_email;
    }

    public String getEmptyPhoneError(){
        return inputPage.empty_phone;
    }

    public String getEmptyAddressError(){
        return inputPage.empty_address;
    }

    public String getEmptyStateError(){
        return inputPage.empty_state;
    }

    public String getEmptyCityError(){
        return inputPage.empty_city;
    }

    public String getEmptyZipCodeError(){
        return inputPage.empty_zip_code;
    }

    public String getEmptyProjectDescError(){
        return inputPage.empty_project_desc;
    }

    public String autocloseableSuccessMessage(){
        return alertPage.autocloseable_success_message;
    }

    public String normalSuccessMessage(){
        return alertPage.normal_success_message;
    }

    public String autocloseableWarningMessage(){
        return alertPage.autocloseable_warning_message;
    }

    public String normalWarningMessage(){
        return alertPage.normal_warning_message;
    }

    public String autocloseableDangerMessage(){
        return alertPage.autocloseable_danger_message;
    }

    public String normalDangerMessage(){
        return alertPage.normal_danger_message;
    }

    public String autocloseableInfoMessage(){
        return alertPage.autocloseable_info_message;
    }

    public String normalInfoMessage(){
        return alertPage.normal_info_message;
    }

    public String leftBoxItem(){
        return listBoxPage.left_item_1;
    }

    public String rightBoxItem(){
        return listBoxPage.right_item_1;
    }

    public String boxItem(){
        return listBoxPage.item;
    }
}
