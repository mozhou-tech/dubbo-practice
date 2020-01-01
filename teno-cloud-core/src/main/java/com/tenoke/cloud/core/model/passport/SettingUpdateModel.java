package com.tenoke.cloud.core.model.passport;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author jerrylau
 */
@Data
@NoArgsConstructor
public class SettingUpdateModel {

    private String key;

    private String value;

}
