package com.pce;

public class UrlFactory {

    //TODO: check this
    public static String PROVISIONING_SERVICE_LOCATION = "/rpiws/services/ProvisioningService1_0";
    
    private static final String CREATE_USER_URL = "/user";
    private static final String UPDATE_USER_URL = "/user/partner/{partnerId}/userGuid/{userGuid}";
    private static final String GET_USER_URL = "/user/partner/{partnerId}/userGuid/{userGuid}";
    private static final String GET_USER_BY_AUTH_KEY_URL = "/user/partner/{partnerId}/authKey/{authKey}";
    private static final String GET_USER_BY_PARTNER_USER_ID_URL = "/user/partner/{partnerId}/partnerUserId/{partnerUserId}";
    private static final String GENERATE_PIN_VF_URL = "/user/pin/billing-partners/vodafone";
    
    private static final String USERS_UPDATE_URL = "/users/update";
    private static final String USERS_ADD_URL = "/users/add";
    private static final String GET_USER_INFO_BY_PARTNER_USER_ID_URL = "/users/user-info/partner/{partnerId}/partnerUserId/{partnerUserId}";
    private static final String GET_USER_INFO_BY_AUTH_KEY_URL = "/users/user-info/partner/{partnerId}/auth-key/{authKey}";
    
    private static final String UPDATE_MDN_URL = "/mdn/partner/{partnerId}/userGuid/{userGuid}";
    private static final String VALIDATE_MDN_FOR_PARTNER_URL = "/mdn/billing-partners/{billingPartnerCode}/validateMdn";
    private static final String VALIDATE_MDN_TMOBILE_URL = "/mdn/billing-partners/tmobile/validate-mdn";
    private static final String INIT_MDN_VALIDATION_FOR_PARTNER_URL = "/mdn/billing-partners/{billingPartnerCode}/initiateMdnValidation";
    private static final String INIT_MDN_VALIDATION_TMOBILE_URL = "/mdn/billing-partners/tmobile/initiate-mdn-validation";
    
    private static final String CREATE_PAYMENT_URL = "/payment/partner/{partnerId}/userGuid/{userGuid}";
    private static final String GET_PAYMENT_URL = "/payments/partner/{partnerId}/userGuid/{userGuid}";
    
    private static final String ADD_UPDATE_SUBSCRIPTION_URL = "/subscription/partner/{partnerId}/userGuid/{userGuid}";
    
    private static final String SUBSCRIPTION_SIGNUP_URL = "/subscriptions/sign-up";
    private static final String SUBSCRIPTION_UPDATE_URL = "/subscriptions/update";
    private static final String SUBSCRIPTION_ADD_URL = "/subscriptions/add";
    private static final String GET_SUBSCRIPTION_URL = "/subscriptions/partner/{partnerId}/userGuid/{userGuid}";
    private static final String INIT_ATT_PURCHASE_URL = "/subscriptions/initiate-purchase";
    private static final String ADD_SUBSCRIPTION_PARTNER_URL = "/subscriptions/billing-partners/{billingPartnerCode}";
    private static final String GET_USER_INFO_SPRINT_URL = "/subscriptions/current-product/billing-partners/sprint?mdn={mdn}";
    private static final String GET_USER_INFO_TMOBILE_URL = "/subscriptions/current-product/billing-partners/tmobile";
    private static final String CANCEL_SUBSCRIPTION_FOR_PARTNER_URL = "/subscriptions/billing-partners/{billingPartnerCode}/user-guids/{guid}/unsubscribe";
    private static final String CANCEL_SUBSCRIPTION_BTM_URL = "/subscriptions/billing-partners/btm/user-guids/{userGuid}";
    private static final String CANCEL_SUBSCRIPTION_VIVO_URL = "/subscriptions/billing-partners/vivo/user-guids/{guid}/unsubscribe/{reason}";
    private static final String CANCEL_SUBSCRIPTION_VF_URL = "/subscriptions/billing-partners/vodafone/cancel";
    private static final String CANCEL_SUBSCRIPTION_PKG_SUB_ID_VF_URL = "/subscriptions/billing-partners/vodafone/user-guids/{userGuid}/sub-ids/{packageSubscriptionId}";
    private static final String GET_SUBSCRIPTION_STATUS_BTM_URL = "/subscriptions/billing-partners/btm/user-guids/{userGuid}";
    private static final String GET_PURCHASE_OPTIONS = "/subscriptions/purchase-options/partner/{partnerId}/userGuid/{userGuid}";
    private static final String GET_PURCHASE_OPTIONS_FOR_PARTNER_URL = "/subscriptions/billing-partners/{billingPartnerCode}/purchase-options?user-guid={userGuid}";
    private static final String GET_PURCHASE_OPTIONS_VF_URL = "/subscriptions/purchase-options/billing-partners/vodafone";
    private static final String GET_PURCHASE_OPTIONS_BLIPBLIP_URL = "/subscriptions/purchase-options/blipblip?billing-partner-code=MSTR_CO&user-guid={userGuid}&mdn={mdn}";
    private static final String GET_SUBSCRIPTION_HISTORY_VF_URL = "/subscriptions/billing-partners/vodafone/user-guids/{userGuid}/msisdns/{msisdn}";
    private static final String GET_SUBSCRIPTION_HISTORY_NO_MSISDN_VF_URL = "/subscriptions/billing-partners/vodafone/user-guids/{userGuid}";
    private static final String DELETE_FUTURE_PURCHASE_VIVO_URL = "/subscriptions/billing-partners/vivo/user-guids/{guid}/nextsubscription";
    private static final String PROCESS_PENDING_TRIAL_TX_VIVO_URL = "/subscriptions/billing-partners/vivo/tx/{txId}/processPendingFreeTrialTx";
    private static final String CHECK_SUBSCRIPTION_TX_STATUS_URL = "/subscriptions/billing-partners/{billingPartnerCode}/tx/{txId}";
    private static final String SWITCH_SUBSCRIPTION_BTM_URL = "/subscriptions/switch/billing-partners/btm/user-guids/{userGuid}";
    
    private static final String CHECK_ELIGIBILITY_BTM_URL = "/eligibility/billing-partners/btm?mdn={mdn}";
    private static final String GET_ELIGIBILITY_DETAIL_BTM_URL = "/eligibility-detail/billing-partners/btm?merchantOrderInfo={merchantOrderInfo}";
    
    private static final String SEND_NOTIFICATION_URL = "/notifications/{billingPartner}";
    private static final String SEND_SMS_NOTIFICATION_URL = "/notifications/tmobile/sms-status";
    private static final String SEND_OM_NOTIFICATION_URL = "/notifications/om/types/{type}"; 
    private static final String PROCESS_OM_NOTIFICATION_URL = "/notifications/om/notification";
    
    private static final String VALIDATE_ZIP_BTM_URL = "/validation-detail/billing-partners/btm?consumerMdn={mdn}&consumerBillingZip={zip}";
    
    private static final String GET_PURCHASE_HISTORY_VF_URL = "/transactions/billing-partners/vodafone/user-guids/{userGuid}/msisdns/{msisdn}";
    private static final String REFUND_VF_URL = "/transactions/billing-partners/vodafone/user-guids/{userGuid}/tx-ids/{transactionId}";
    
    private static final String GET_PRODUCT_SETUP_URL = "/product-setups?product-name={productName}";
    
    private static final String GENERATE_CODE_SPDY_AR_URL = "/billing-partners/spdy_ar/generate-code";
    private static final String REDEEM_CODE_SPDY_AR_URL = "/billing-partners/spdy_ar/redeem-code";
    private static final String GET_CODE_SPDY_AR_URL = "/billing-partners/spdy_ar/serial-code/{serialCode}";
    private static final String VERIFY_CODE_SPDY_AR_URL = "/billing-partners/spdy_ar/verify-code/{serialCode}";
    
    private static final String PUBLISH_TMOBILE_EVENT_URL = "";
    
    private static final String CLEAR_CACHE_URL = "/caches/evict-all";
    
    private static final String BTM_SIM_CHECK_ELIGIBILITY_URL = "/{action}/{phoneNumber}";
    
    private static final String ATT_DCM_MAKE_PURCHASE_URL = "/rest/config/make-purchase/{vendorPurchaseId}";
    private static final String ATT_DCM_CONFIG_ALL_URL = "/rest/config/All";
    
    private static final String SPRINT_CONFIG_PARTNER_TX_RESP_URL = "/config/{profileId}/partnerTransactionResponse";
    private static final String SPRINT_CONFIG_QUERY_RESP_URL = "/config/{profileId}/queryResponse";
    
    private static final String TMOBILE_CONFIG_NAP_URL = "/config/nap/query/{msisdn}";
    private static final String TMOBILE_CONFIG_NAP_CUSTID_URL = "/config/nap/query/customer-id/{customerId}";
    private static final String TMOBILE_CONFIG_NAP_RESP_TIME_URL = "/config/nap/perf/{processingMiliseconds}";
    private static final String TMOBILE_CONFIG_NAP_ERROR_URL = "/config/nap/error/{msisdn}/{errorCode}";
    private static final String TMOBILE_GET_NAP_CONFIG_URL = "/config/nap/{action}/{msisdn}";
    private static final String TMOBILE_CONFIG_MA_URL = "/config/ma/{msisdn}";
    private static final String TMOBILE_CONFIG_MA_ERROR_URL = "/config/ma/error/{msisdn}/{errorCode}";
    private static final String TMOBILE_TRANSACT_NAP_URL = "/nap";
    private static final String TMOBILE_TRANSACT_MA_URL = "/ma";
    private static final String TMOBILE_CONFIG_ALL_URL = "/config/all";
    
    private static final String MSTR_GET_MOB_INFO_URL = "/get-mobile-info/{phoneNumber}";
    private static final String MSTR_SEND_SMS_URL = "/send-sms/{phoneNumber}";
    private static final String MSTR_SEND_CHG_INFO_URL = "/send-charge-info/{phoneNumber}";
    
    private static final String VF_PUT_CONFIG_URL = "/rest/config/{action}";
    private static final String VF_GET_CONFIG_URL = "/rest/config/{action}/{id}";
    private static final String VF_ALL_CONFIG_URL = "/rest/config/All";
    
    private String baseUrl;
    
    public UrlFactory(String baseUrl) {
        this.baseUrl = baseUrl;
    }
    
    private String url(String urlPath) {
        return baseUrl + urlPath;
    }
    
    /**
     * Att 
     */
    public String initAttPurchaseUrl() {
        return url(INIT_ATT_PURCHASE_URL);
    }
    
    /**
     * Sprint 
     */
    public String getUserInfoSprintUrl() {
        return url(GET_USER_INFO_SPRINT_URL);
    }
    
    /**
     * BTM 
     */
    public String checkEligibilityBtmUrl() {
        return url(CHECK_ELIGIBILITY_BTM_URL);
    }
    
    public String getEligibilityDetailBtmUrl() {
        return url(GET_ELIGIBILITY_DETAIL_BTM_URL);
    }
    
    public String validateZipBtmUrl() {
        return url(VALIDATE_ZIP_BTM_URL);
    }
    
    public String cancelSubscriptionBtmUrl() {
        return url(CANCEL_SUBSCRIPTION_BTM_URL);
    }
    
    public String getSubscriptionStatusBtmUrl() {
        return url(GET_SUBSCRIPTION_STATUS_BTM_URL);
    }
    
    public String switchSubscriptionBtmUrl() {
        return url(SWITCH_SUBSCRIPTION_BTM_URL);
    }
    
    /**
     * Vodafone 
     */
    public String getPurchaseOptionsVfUrl() {
        return url(GET_PURCHASE_OPTIONS_VF_URL);
    }
    
    public String getPurchaseHistoryVfUrl() {
        return url(GET_PURCHASE_HISTORY_VF_URL);
    }
    
    public String refundVfUrl() {
        return url(REFUND_VF_URL);
    }
    
    public String getSubscriptionHistoryVfUrl() {
        return url(GET_SUBSCRIPTION_HISTORY_VF_URL);
    }
    
    public String getSubscriptionHistoryNoMsisdnVfUrl() {
        return url(GET_SUBSCRIPTION_HISTORY_NO_MSISDN_VF_URL);
    }
    
    public String cancelSubscriptionVfUrl() {
        return url(CANCEL_SUBSCRIPTION_VF_URL);
    }
    
    public String cancelSubscriptionByPkgSubIdVfUrl() {
        return url(CANCEL_SUBSCRIPTION_PKG_SUB_ID_VF_URL);
    }
    
    public String generatePinVfUrl() {
        return url(GENERATE_PIN_VF_URL);
    }
    
    /**
     * Vivo 
     */
    public String deleteFuturePurchaseVivoUrl() {
        return url(DELETE_FUTURE_PURCHASE_VIVO_URL);
    }
    
    public String processPendingTrialTxVivoUrl() {
        return url(PROCESS_PENDING_TRIAL_TX_VIVO_URL);
    }
    
    public String cancelSubscriptionVivoUrl() {
        return url(CANCEL_SUBSCRIPTION_VIVO_URL);
    }
    
    /**
     * Speedy 
     */
    public String generateCodeSpdyArUrl() {
        return url(GENERATE_CODE_SPDY_AR_URL);
    }
    
    public String redeemCodeSpdyArUrl() {
        return url(REDEEM_CODE_SPDY_AR_URL);
    }
    
    public String getCodeSpdyArUrl() {
        return url(GET_CODE_SPDY_AR_URL);
    }
    
    public String verifyCodeSpdyArUrl() {
        return url(VERIFY_CODE_SPDY_AR_URL);
    }
    
    /**
     * Tmobile 
     */
    public String initMdnValidationTmobileUrl() {
        return url(INIT_MDN_VALIDATION_TMOBILE_URL);
    }
    
    public String validateMdnTmobileUrl() {
        return url(VALIDATE_MDN_TMOBILE_URL);
    }
    
    public String sendSmsNotificationTmobileUrl() {
        return url(SEND_SMS_NOTIFICATION_URL);
    }
    
    public String getUserInfoTmobileUrl() {
        return url(GET_USER_INFO_TMOBILE_URL);
    }
    
    public String publishTmobileEventUrl() {
        return url(PUBLISH_TMOBILE_EVENT_URL);
    }
    
    /**
     * Blipblip 
     */
    public String getPurchaseOptionsBlipblipUrl() {
        return url(GET_PURCHASE_OPTIONS_BLIPBLIP_URL);
    }
    
    /**
     * OM notifications 
     */
    public String sendOmNotificationUrl() {
        return url(SEND_OM_NOTIFICATION_URL);
    }
    
    public String processOmNotification() {
        return url(PROCESS_OM_NOTIFICATION_URL);
    }
    
    /**
     * General partner API 
     */
    public String addSubscriptionForPartnerUrl() {
        return url(ADD_SUBSCRIPTION_PARTNER_URL);
    }
    
    public String sendNotificationUrl() {
        return url(SEND_NOTIFICATION_URL);
    }
    
    public String cancelSubscriptionForParnterUrl() {
        return url(CANCEL_SUBSCRIPTION_FOR_PARTNER_URL);
    }
    
    public String validateMdnForPartnerUrl() {
        return url(VALIDATE_MDN_FOR_PARTNER_URL);
    }
    
    public String initMdnValidationForParnterUrl() {
        return url(INIT_MDN_VALIDATION_FOR_PARTNER_URL);
    }
    
    public String getPurchaseOptions() {
        return url(GET_PURCHASE_OPTIONS);
    }

    public String getPurchaseOptionsForParnterUrl() {
        return url(GET_PURCHASE_OPTIONS_FOR_PARTNER_URL);
    }
    
    public String checkSubscriptionTxStatusUrl() {
        return url(CHECK_SUBSCRIPTION_TX_STATUS_URL);
    }
    
    /**
     * General API - subscriptions 
     */
    public String subscriptionSignupUrl() {
        return url(SUBSCRIPTION_SIGNUP_URL);
    }
    
    public String subscriptionAddUrl() {
        return url(SUBSCRIPTION_ADD_URL);
    }
    
    public String subscriptionUpdateUrl() {
        return url(SUBSCRIPTION_UPDATE_URL);
    }
    
    public String getSubscriptionUrl() {
        return url(GET_SUBSCRIPTION_URL);
    }
    
    public String addUpdateSubscriptionUrl() {
        return url(ADD_UPDATE_SUBSCRIPTION_URL);
    }
    
    /**
     * General API - users 
     */
    public String usersAddUrl() {
        return url(USERS_ADD_URL);
    }
    
    public String usersUpdateUrl() {
        return url(USERS_UPDATE_URL);
    }
    
    public String createUserUrl() {
        return url(CREATE_USER_URL);
    }
    
    public String getUserUrl() {
        return url(GET_USER_URL);
    }
    
    public String updateUserUrl() {
        return url(UPDATE_USER_URL);
    }
    
    public String getUserInfoByParnterUserIdUrl() {
        return url(GET_USER_INFO_BY_PARTNER_USER_ID_URL);
    }
    
    public String getUserByAuthKeyUrl() {
        return url(GET_USER_BY_AUTH_KEY_URL);
    }
    
    public String gerUserByPartnerUserIdUrl() {
        return url(GET_USER_BY_PARTNER_USER_ID_URL);
    }
    
    public String getUserInfoByAuthKeyUrl() {
        return url(GET_USER_INFO_BY_AUTH_KEY_URL);
    }
    
    public String updateMdnUrl() {
        return url(UPDATE_MDN_URL);
    }
    
    /**
     * Payment 
     */
    public String getPaymentUrl() {
        return url(GET_PAYMENT_URL);
    }
    
    public String createPaymentUrl() {
        return url(CREATE_PAYMENT_URL);
    }
    
    /**
     * Product setup 
     */
    public String getProductSetupUrl() {
        return url(GET_PRODUCT_SETUP_URL);
    }
    
    /**
     * RPIWS clear cache 
     */
    public String clearCacheUrl() {
        return url(CLEAR_CACHE_URL);
    }
    
    /**
     * BTM simulator 
     */
    public String configBtmSimCheckEligibilityUrl() {
        return url(BTM_SIM_CHECK_ELIGIBILITY_URL);
    }
    
    /**
     * ATT DCM simulator
     */
    public String configAttDcmMakePurchaseUrl() {
        return url(ATT_DCM_MAKE_PURCHASE_URL);
    }
    
    public String configAllUrl() {
        return url(ATT_DCM_CONFIG_ALL_URL);
    }
    
    /**
     * Sprint simulator
     */
    public String configSprintPartnerTxRespUrl() {
        return url(SPRINT_CONFIG_PARTNER_TX_RESP_URL);
    }
    
    public String configSprintQueryRespUrl() {
        return url(SPRINT_CONFIG_QUERY_RESP_URL);
    }
    
    /**
     * Tmobile simulator
     */
    public String configTmobileNapUrl() {
        return url(TMOBILE_CONFIG_NAP_URL);
    }
    
    public String configTmobileNapByCustomerIdUrl() {
        return url(TMOBILE_CONFIG_NAP_CUSTID_URL);
    }
    
    public String configTmobileNapRespTimeUrl() {
        return url(TMOBILE_CONFIG_NAP_RESP_TIME_URL);
    }
    
    public String configTmobileNapErrorUrl() {
        return url(TMOBILE_CONFIG_NAP_ERROR_URL);
    }
    
    public String getTmobileNapConfigUrl() {
        return url(TMOBILE_GET_NAP_CONFIG_URL);
    }
    
    public String configTmobileMaUrl() {
        return url(TMOBILE_CONFIG_MA_URL);
    }
    
    public String configTmobileMaErrorUrl() {
        return url(TMOBILE_CONFIG_MA_ERROR_URL);
    }
    
    public String transactTmobileNapUrl() {
        return url(TMOBILE_TRANSACT_NAP_URL);
    }
    
    public String transactTmobileMaUrl() {
        return url(TMOBILE_TRANSACT_MA_URL);
    }
    
    public String allTmobileConfigUrl() {
        return url(TMOBILE_CONFIG_ALL_URL);
    }
    
    /**
     * Movistar simulator
     */
    public String mstrGetMobileInfoUrl() {
        return url(MSTR_GET_MOB_INFO_URL);
    }
    
    public String mstrSendSmsUrl() {
        return url(MSTR_SEND_SMS_URL);
    }
    
    public String mstrSendChargeInfoUrl() {
        return url(MSTR_SEND_CHG_INFO_URL);
    }
    
    /**
     * Vodafone simulator
     */
    public String vfPutConfigUrl() {
        return url(VF_PUT_CONFIG_URL);
    }
    
    public String vfGetCofnigUrl() {
        return url(VF_GET_CONFIG_URL);
    }
    
    public String vfConfigAllUrl() {
        return url(VF_ALL_CONFIG_URL);
    }
}