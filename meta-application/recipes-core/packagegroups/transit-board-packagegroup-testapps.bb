DESCRIPTION = "Transit board application packagegroup"
SUMMARY = "Transit board packagegroup - tools/testapps"

PACKAGE_ARCH = "${MACHINE_ARCH}"

inherit packagegroup

RDEPENDS_${PN} = " \
    ethtool \
    gdb \
    binutils \
    i2c-tools \
    memtester \
"
