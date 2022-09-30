package com.readingisgood.model;

import lombok.experimental.UtilityClass;

@UtilityClass
public class Constants {
    public final String EMAIL_REGEX = "^[A-Z0-9a-z._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,64}$";
    public final String PASSWORD_REGEX = "^(\\d)\\1{3}$";

    public final String HEADER_CLIENT_ID = "X-Client-Id";
    public final String ATTR_COMPANY_ID = "companyId";
    public final String ATTR_CUSTOMER_ID = "customerId";
    public final String ATTR_LOCALE_CODE = "localeCode";

    public final String COMPANY_CAMPAIGN_ACCEPTED = "PRM_COMPANY_CAMPAIGN_ACCEPTED";
    public final String ACTIVE = "1";
}
