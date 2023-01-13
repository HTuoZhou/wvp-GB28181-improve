--
-- Table structure for table `device`
--
DROP TABLE IF EXISTS `device`;
CREATE TABLE `device`
(
    `id`                               int                                                          NOT NULL AUTO_INCREMENT,
    `deviceId`                         varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
    `name`                             varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
    `manufacturer`                     varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
    `model`                            varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
    `firmware`                         varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
    `transport`                        varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci  DEFAULT NULL,
    `streamMode`                       varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci  DEFAULT NULL,
    `online`                           int  DEFAULT NULL,
    `registerTime`                     datetime                                                     NOT NULL,
    `keepaliveTime`                    datetime                                                     NOT NULL,
    `ip`                               varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci  DEFAULT NULL,
    `createTime`                       datetime                                                     NOT NULL,
    `updateTime`                       datetime                                                     NOT NULL,
    `port`                             int                                                           DEFAULT NULL,
    `expires`                          int                                                           DEFAULT NULL,
    `subscribeCycleForCatalog`         int                                                           DEFAULT NULL,
    `hostAddress`                      varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci  DEFAULT NULL,
    `charset`                          varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
    `subscribeCycleForMobilePosition`  int                                                           DEFAULT NULL,
    `mobilePositionSubmissionInterval` int                                                           DEFAULT '5',
    `subscribeCycleForAlarm`           int                                                           DEFAULT NULL,
    `ssrcCheck`                        int                                                           DEFAULT '0',
    `geoCoordSys`                      varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
    `treeType`                         varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
    `customName`                       varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
    `password`                         varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
    `sdpIp`                            varchar(50) COLLATE utf8mb4_general_ci                        DEFAULT NULL,
    `localIp`                          varchar(50) COLLATE utf8mb4_general_ci                        DEFAULT NULL,
    PRIMARY KEY (`id`),
    UNIQUE KEY `device_deviceId_uindex` (`deviceId`)
)
    ENGINE = InnoDB
    AUTO_INCREMENT = 1
    CHARACTER SET = utf8mb4
    COLLATE = utf8mb4_general_ci;


--
-- Table structure for table `device_alarm`
--
DROP TABLE IF EXISTS `device_alarm`;
CREATE TABLE `device_alarm`
(
    `id`               int                                                          NOT NULL AUTO_INCREMENT,
    `deviceId`         varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
    `channelId`        varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
    `alarmPriority`    varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
    `alarmMethod`      varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci  DEFAULT NULL,
    `alarmTime`        datetime                                                     NOT NULL,
    `alarmDescription` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
    `longitude`        double                                                        DEFAULT NULL,
    `latitude`         double                                                        DEFAULT NULL,
    `alarmType`        varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci  DEFAULT NULL,
    `createTime`       datetime                                                     NOT NULL,
    PRIMARY KEY (`id`) USING BTREE
)
    ENGINE = InnoDB
    AUTO_INCREMENT = 1
    CHARACTER SET = utf8mb4
    COLLATE = utf8mb4_general_ci;


--
-- Table structure for table `device_channel`
--
DROP TABLE IF EXISTS `device_channel`;
CREATE TABLE `device_channel`
(
    `id`              int                                                          NOT NULL AUTO_INCREMENT,
    `channelId`       varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
    `name`            varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
    `manufacture`     varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci  DEFAULT NULL,
    `model`           varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci  DEFAULT NULL,
    `owner`           varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci  DEFAULT NULL,
    `civilCode`       varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci  DEFAULT NULL,
    `block`           varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci  DEFAULT NULL,
    `address`         varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci  DEFAULT NULL,
    `parentId`        varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci  DEFAULT NULL,
    `safetyWay`       int                                                           DEFAULT NULL,
    `registerWay`     int                                                           DEFAULT NULL,
    `certNum`         varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci  DEFAULT NULL,
    `certifiable`     int                                                           DEFAULT NULL,
    `errCode`         int                                                           DEFAULT NULL,
    `endTime`         datetime                                                     NOT NULL,
    `secrecy`         varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci  DEFAULT NULL,
    `ipAddress`       varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci  DEFAULT NULL,
    `port`            int                                                           DEFAULT NULL,
    `password`        varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
    `PTZType`         int                                                           DEFAULT NULL,
    `status`          int                                                           DEFAULT NULL,
    `longitude`       double                                                        DEFAULT NULL,
    `latitude`        double                                                        DEFAULT NULL,
    `streamId`        varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci  DEFAULT NULL,
    `deviceId`        varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
    `parental`        varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci  DEFAULT NULL,
    `hasAudio`        bit(1)                                                        DEFAULT NULL,
    `createTime`      datetime                                                     NOT NULL,
    `updateTime`      datetime                                                     NOT NULL,
    `subCount`        int                                                           DEFAULT '0',
    `longitudeGcj02`  double                                                        DEFAULT NULL,
    `latitudeGcj02`   double                                                        DEFAULT NULL,
    `longitudeWgs84`  double                                                        DEFAULT NULL,
    `latitudeWgs84`   double                                                        DEFAULT NULL,
    `businessGroupId` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci  DEFAULT NULL,
    `gpsTime`         datetime                                                     NOT NULL,
    PRIMARY KEY (`id`),
    UNIQUE KEY `device_channel_id_uindex` (`id`),
    UNIQUE KEY `device_channel_pk` (`channelId`, `deviceId`)
)
    ENGINE = InnoDB
    AUTO_INCREMENT = 1
    CHARACTER SET = utf8mb4
    COLLATE = utf8mb4_general_ci;


--
-- Table structure for table `device_mobile_position`
--
DROP TABLE IF EXISTS `device_mobile_position`;
CREATE TABLE `device_mobile_position`
(
    `id`             int                                                          NOT NULL AUTO_INCREMENT,
    `deviceId`       varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
    `channelId`      varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
    `deviceName`     varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
    `time`           datetime                                                     NOT NULL,
    `longitude`      double                                                       NOT NULL,
    `latitude`       double                                                       NOT NULL,
    `altitude`       double                                                        DEFAULT NULL,
    `speed`          double                                                        DEFAULT NULL,
    `direction`      double                                                        DEFAULT NULL,
    `reportSource`   varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci  DEFAULT NULL,
    `longitudeGcj02` double                                                        DEFAULT NULL,
    `latitudeGcj02`  double                                                        DEFAULT NULL,
    `longitudeWgs84` double                                                        DEFAULT NULL,
    `latitudeWgs84`  double                                                        DEFAULT NULL,
    `createTime`     datetime                                                     NOT NULL,
    PRIMARY KEY (`id`)
)
    ENGINE = InnoDB
    AUTO_INCREMENT = 1
    CHARACTER SET = utf8mb4
    COLLATE = utf8mb4_general_ci;


--
-- Table structure for table `gb_stream`
--
DROP TABLE IF EXISTS `gb_stream`;
CREATE TABLE `gb_stream`
(
    `gbStreamId`    int                                                           NOT NULL AUTO_INCREMENT,
    `app`           varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
    `stream`        varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
    `gbId`          varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci  NOT NULL,
    `name`          varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
    `longitude`     double                                                        DEFAULT NULL,
    `latitude`      double                                                        DEFAULT NULL,
    `streamType`    varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci  DEFAULT NULL,
    `mediaServerId` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci  DEFAULT NULL,
    `createTime`    datetime                                                      NOT NULL,
    PRIMARY KEY (`gbStreamId`) USING BTREE,
    UNIQUE KEY `app` (`app`, `stream`) USING BTREE,
    UNIQUE KEY `gbId` (`gbId`) USING BTREE
)
    ENGINE = InnoDB
    AUTO_INCREMENT = 1
    CHARACTER SET = utf8mb4
    COLLATE = utf8mb4_general_ci;


--
-- Table structure for table `log`
--
DROP TABLE IF EXISTS `log`;
CREATE TABLE `log`
(
    `id`         int                                                           NOT NULL AUTO_INCREMENT,
    `name`       varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci  NOT NULL,
    `type`       varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci  NOT NULL,
    `uri`        varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
    `address`    varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci  NOT NULL,
    `result`     varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci  NOT NULL,
    `timing`     bigint                                                        NOT NULL,
    `username`   varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci  NOT NULL,
    `createTime` datetime                                                      NOT NULL,
    PRIMARY KEY (`id`) USING BTREE
)
    ENGINE = InnoDB
    AUTO_INCREMENT = 1
    CHARACTER SET = utf8mb4
    COLLATE = utf8mb4_general_ci;


--
-- Table structure for table `media_server`
--
DROP TABLE IF EXISTS `media_server`;
CREATE TABLE `media_server`
(
    `id`                int                                                           NOT NULL AUTO_INCREMENT,
    `serverId`          varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
    `ip`                varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci  NOT NULL,
    `hookIp`            varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci  NOT NULL,
    `sdpIp`             varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci  NOT NULL,
    `streamIp`          varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci  NOT NULL,
    `httpPort`          int                                                           NOT NULL,
    `httpSSlPort`       int                                                           NOT NULL,
    `rtmpPort`          int                                                           NOT NULL,
    `rtmpSSlPort`       int                                                           NOT NULL,
    `rtpProxyPort`      int                                                           NOT NULL,
    `rtspPort`          int                                                           NOT NULL,
    `rtspSSLPort`       int                                                           NOT NULL,
    `autoConfig`        int                                                           NOT NULL,
    `secret`            varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci  NOT NULL,
    `rtpEnable`         int                                                           NOT NULL,
    `rtpPortRange`      varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci  NOT NULL,
    `recordAssistPort`  int                                                           NOT NULL,
    `defaultServer`     int                                                           NOT NULL,
    `createTime`        datetime                                                      NOT NULL,
    `updateTime`        datetime                                                      NOT NULL,
    `hookAliveInterval` int                                                           NOT NULL,
    `hookAliveLastTime` datetime,
    PRIMARY KEY (`id`) USING BTREE
)
    ENGINE = InnoDB
    AUTO_INCREMENT = 1
    CHARACTER SET = utf8mb4
    COLLATE = utf8mb4_general_ci;


--
-- Table structure for table `parent_platform`
--
DROP TABLE IF EXISTS `parent_platform`;
CREATE TABLE `parent_platform`
(
    `id`                     int                                                          NOT NULL AUTO_INCREMENT,
    `enable`                 int                                                           DEFAULT NULL,
    `name`                   varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
    `serverGBId`             varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
    `serverGBDomain`         varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci  DEFAULT NULL,
    `serverIP`               varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci  DEFAULT NULL,
    `serverPort`             int                                                           DEFAULT NULL,
    `deviceGBId`             varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
    `deviceIp`               varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci  DEFAULT NULL,
    `devicePort`             varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci  DEFAULT NULL,
    `username`               varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
    `password`               varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci  DEFAULT NULL,
    `expires`                varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci  DEFAULT NULL,
    `keepTimeout`            datetime                                                     NOT NULL,
    `transport`              varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci  DEFAULT NULL,
    `characterSet`           varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci  DEFAULT NULL,
    `catalogId`              varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
    `ptz`                    int                                                           DEFAULT NULL,
    `rtcp`                   int                                                           DEFAULT NULL,
    `status`                 bit(1)                                                        DEFAULT NULL,
    `startOfflinePush`       int                                                           DEFAULT '0',
    `administrativeDivision` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
    `catalogGroup`           int                                                           DEFAULT '1',
    `createTime`             datetime                                                     NOT NULL,
    `updateTime`             datetime                                                     NOT NULL,
    `treeType`               varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
    PRIMARY KEY (`id`),
    UNIQUE KEY `parent_platform_id_uindex` (`id`),
    UNIQUE KEY `parent_platform_pk` (`serverGBId`)
)
    ENGINE = InnoDB
    AUTO_INCREMENT = 1
    CHARACTER SET = utf8mb4
    COLLATE = utf8mb4_general_ci;


--
-- Table structure for table `platform_catalog`
--
DROP TABLE IF EXISTS `platform_catalog`;
CREATE TABLE `platform_catalog`
(
    `id`              varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci  NOT NULL,
    `platformId`      varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci  NOT NULL,
    `name`            varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
    `parentId`        varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
    `civilCode`       varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
    `businessGroupId` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
    PRIMARY KEY (`id`) USING BTREE
)
    ENGINE = InnoDB
    AUTO_INCREMENT = 1
    CHARACTER SET = utf8mb4
    COLLATE = utf8mb4_general_ci;


--
-- Table structure for table `platform_gb_stream`
--
DROP TABLE IF EXISTS `platform_gb_stream`;
CREATE TABLE `platform_gb_stream`
(
    `id`         int                                                          NOT NULL AUTO_INCREMENT,
    `platformId` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
    `catalogId`  varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
    `gbStreamId` int                                                          NOT NULL,
    PRIMARY KEY (`id`),
    UNIQUE KEY `platform_gb_stream_pk` (`platformId`, `catalogId`, `gbStreamId`)
)
    ENGINE = InnoDB
    AUTO_INCREMENT = 1
    CHARACTER SET = utf8mb4
    COLLATE = utf8mb4_general_ci;


--
-- Table structure for table `platform_gb_channel`
--
DROP TABLE IF EXISTS `platform_gb_channel`;
CREATE TABLE `platform_gb_channel`
(
    `id`              int                                                          NOT NULL AUTO_INCREMENT,
    `platformId`      varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
    `catalogId`       varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
    `deviceChannelId` int                                                          NOT NULL,
    PRIMARY KEY (`id`)
)
    ENGINE = InnoDB
    AUTO_INCREMENT = 1
    CHARACTER SET = utf8mb4
    COLLATE = utf8mb4_general_ci;


--
-- Table structure for table `stream_proxy`
--

DROP TABLE IF EXISTS `stream_proxy`;
CREATE TABLE `stream_proxy`
(
    `id`                         int                                                           NOT NULL AUTO_INCREMENT,
    `type`                       varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci  NOT NULL,
    `app`                        varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
    `stream`                     varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
    `url`                        varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
    `src_url`                    varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
    `dst_url`                    varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
    `timeout_ms`                 int                                                           DEFAULT NULL,
    `ffmpeg_cmd_key`             varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
    `rtp_type`                   varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci  DEFAULT NULL,
    `mediaServerId`              varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci  DEFAULT NULL,
    `enable_audio`               bit(1)                                                        DEFAULT NULL,
    `enable_mp4`                 bit(1)                                                        DEFAULT NULL,
    `enable`                     bit(1)                                                        NOT NULL,
    `status`                     bit(1)                                                        NOT NULL,
    `enable_remove_none_reader`  bit(1)                                                        NOT NULL,
    `createTime`                 datetime                                                      NOT NULL,
    `name`                       varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
    `updateTime`                 datetime                                                      NOT NULL,
    `enable_disable_none_reader` bit(1)                                                        DEFAULT NULL,
    PRIMARY KEY (`id`),
    UNIQUE KEY `stream_proxy_pk` (`app`, `stream`)
)
    ENGINE = InnoDB
    AUTO_INCREMENT = 1
    CHARACTER SET = utf8mb4
    COLLATE = utf8mb4_general_ci;


--
-- Table structure for table `stream_push`
--
DROP TABLE IF EXISTS `stream_push`;
CREATE TABLE `stream_push`
(
    `id`               int                                                           NOT NULL AUTO_INCREMENT,
    `app`              varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
    `stream`           varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
    `totalReaderCount` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
    `originType`       int                                                          DEFAULT NULL,
    `originTypeStr`    varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
    `createTime`       datetime                                                      NOT NULL,
    `aliveSecond`      int                                                          DEFAULT NULL,
    `mediaServerId`    varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
    `serverId`         varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci  NOT NULL,
    `pushTime`         datetime                                                      NOT NULL,
    `status`           int                                                          DEFAULT NULL,
    `updateTime`       datetime                                                      NOT NULL,
    `pushIng`          int                                                          DEFAULT NULL,
    `self`             int                                                          DEFAULT NULL,
    PRIMARY KEY (`id`),
    UNIQUE KEY `stream_push_pk` (`app`, `stream`)
)
    ENGINE = InnoDB
    AUTO_INCREMENT = 1
    CHARACTER SET = utf8mb4
    COLLATE = utf8mb4_general_ci;


--
-- Table structure for table `user`
--
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`
(
    `id`         int                                                           NOT NULL AUTO_INCREMENT,
    `username`   varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
    `password`   varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
    `roleId`     int                                                           NOT NULL,
    `createTime` datetime                                                      NOT NULL,
    `updateTime` datetime                                                      NOT NULL,
    `pushKey`    varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
    PRIMARY KEY (`id`) USING BTREE,
    UNIQUE KEY `user_username_uindex` (`username`) USING BTREE
)
    ENGINE = InnoDB
    AUTO_INCREMENT = 1
    CHARACTER SET = utf8mb4
    COLLATE = utf8mb4_general_ci;


INSERT INTO `user`
VALUES (1, 'admin', '21232f297a57a5a743894a0e4a801fc3', 1, '2022-12-15 14:14:57', '2022-12-15 14:14:57',
        '3e80d1762a324d5b0ff636e0bd16f1e3');


--
-- Table structure for table `user_role`
--
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role`
(
    `id`         int                                                          NOT NULL AUTO_INCREMENT,
    `name`       varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
    `authority`  varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
    `createTime` datetime                                                     NOT NULL,
    `updateTime` datetime                                                     NOT NULL,
    PRIMARY KEY (`id`) USING BTREE
)
    ENGINE = InnoDB
    AUTO_INCREMENT = 1
    CHARACTER SET = utf8mb4
    COLLATE = utf8mb4_general_ci;


INSERT INTO `user_role`
VALUES (1, 'admin', '0', '2022-12-15 14:14:57', '2022-12-15 14:14:57');