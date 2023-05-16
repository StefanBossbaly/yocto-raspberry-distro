DESCRIPTION = "Builds the rpi-rgb-led-matrix project and installs the demo"

LICENSE = "GPL"
LIC_FILES_CHKSUM = "file://COPYING;md5=b234ee4d69f5fce4486a80fdaf4a4263"

SRC_URI = "git://github.com/hzeller/rpi-rgb-led-matrix.git;protocol=http;branch=master"
SRCREV = "${AUTOREV}"
PV = "1.0+git${SRCPV}"
S = "${WORKDIR}/git"

inherit python3native

DEPENDS:append = " graphicsmagick libwebp"
RDEPENDS:${PN} += " graphicsmagick-native"

TARGET_CC_ARCH += "${LDFLAGS}"

do_compile() {
    oe_runmake

    oe_runmake -C "${S}/utils" led-image-viewer
}

do_install() {
    install -d ${D}/usr/bin
    install -T ${B}/examples-api-use/demo ${D}/usr/bin/rgb-matrix-demo
    install -T ${B}/utils/led-image-viewer ${D}/usr/bin/led-image-viewer

    install -d ${D}/usr/lib
    install -m 755 ${B}/lib/librgbmatrix.so.1 ${D}/usr/lib/
    install -m 644 ${B}/lib/librgbmatrix.a ${D}/usr/lib/

    install -d ${D}/usr/include/rgb-matrix
    install -m 644 ${B}/include/*.h ${D}/usr/include/rgb-matrix
}