FILESEXTRAPATHS:prepend := "${THISDIR}/libubootenv:"

SRC_URI += "\
            file://fw_env.octeon.sdcard.config \
           "

do_install:append() {
    install -d ${D}${sysconfdir}
    install -m 0644 ${WORKDIR}/fw_env.octeon.sdcard.config ${D}${sysconfdir}/
    ln -sfT fw_env.octeon.sdcard.config ${D}${sysconfdir}/fw_env.config
}
