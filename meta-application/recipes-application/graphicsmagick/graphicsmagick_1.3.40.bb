SUMMARY = "GraphicsMagick is the swiss army knife of image processing"
LICENSE = "GraphicsMagick"
LIC_FILES_CHKSUM = "file://Copyright.txt;md5=d46c64029c86acbab3a4deffc237d406"

DEPENDS = "librsvg"

SRC_URI = "http://downloads.sourceforge.net/project/graphicsmagick/graphicsmagick/${PV}/GraphicsMagick-${PV}.tar.xz \
"

SRC_URI[md5sum] = "eb8395be198a661352dafb98eff5e35c"
SRC_URI[sha256sum] = "97dc1a9d4e89c77b25a3b24505e7ff1653b88f9bfe31f189ce10804b8efa7746"

S = "${WORKDIR}/GraphicsMagick-${PV}"

inherit autotools pkgconfig update-alternatives

# Always disable XML and xml
EXTRA_OECONF = "--without-xml --without-x"

CACHED_CONFIGUREVARS = "ac_cv_sys_file_offset_bits=yes"

# DPS?
# FlashPix?
# JPEG-XL?
# Trio?
# HEIF?
PACKAGECONFIG[bzip2] = "--with-bzlib=yes,--with-bzlib=no,bzip2"
PACKAGECONFIG[ttf] = "--with-ttf=yes,--with-ttf=no,freetype"
PACKAGECONFIG[gs] = "--with-gs=yes,--with-gs=no,ghostscript"
PACKAGECONFIG[jpeg] = "--with-jpeg=yes,--with-jpeg=no,jpeg"
PACKAGECONFIG[jp2] = "--with-jp2=yes,--with-jp2=no,jasper"
PACKAGECONFIG[lcms] = "--with-lcms2=yes,--with-lcms2=no,lcms"
PACKAGECONFIG[lzma] = "--with-lzma=yes,--with-lzma=no,xz"
PACKAGECONFIG[cpp] = "--with-magick-plus-plus=yes,--with-magick-plus-plus=no"
PACKAGECONFIG[perl] = "--with-perl=yes,--with-perl=no,perl"
PACKAGECONFIG[png] = "--with-png=yes,--with-png=no,libpng"
PACKAGECONFIG[tiff] = "--with-tiff=yes,--with-tiff=no,tiff"
PACKAGECONFIG[webp] = "--with-webp=yes,--with-webp=no,libwebp"
PACKAGECONFIG[wmf] = "--with-wmf=yes,--with-wmf=no,libwmf"
PACKAGECONFIG[zlib] = "--with-zlib=yes,--with-zlib=no,zlib"
PACKAGECONFIG[zstd] = "--with-zstd=yes,--with-zstd=no,zstd"

FILES:${PN} += "${libdir}/GraphicsMagick-${PV}/config \
                ${datadir}/GraphicsMagick-${PV} "

BBCLASSEXTEND = "native"