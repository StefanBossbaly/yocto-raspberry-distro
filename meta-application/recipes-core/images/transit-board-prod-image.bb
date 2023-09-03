SUMMARY = "Transit board production image"
LICENSE = "GPL"

IMAGE_FEATURES:append = " allow-empty-password allow-root-login empty-root-password ssh-server-dropbear"

IMAGE_INSTALL:append = " rustic-pixel-display"

# Switch off on-board sound 
RPI_EXTRA_CONFIG = "\
    dtparam=audio=off \
    dtoverlay=disable-bt \
"

# Autoload kernel module
KERNEL_MODULE_AUTOLOAD += "\
    uio_pdrv_genirq \
    uio \
    nvmem_rmem \
    fuse \
"

# Disable vc4graphics
DISABLE_VC4GRAPHICS = "1"

# Disable rpi boot logo
DISABLE_RPI_BOOT_LOGO = "1"

# Disable UART
ENABLE_UART = "0"

# Isolate the last CPU
# TODO(Stefan): Support platforms with less than 4 cores
ISOLATED_CPUS = "3"

DISABLE_OVERSCAN = "1"

GPU_MEM_256 = "16"
GPU_MEM_512 = "16"
GPU_MEM_1024 = "16"

require recipes-core/images/core-image-base.bb