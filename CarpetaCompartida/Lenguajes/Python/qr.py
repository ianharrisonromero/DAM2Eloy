import qrcode
from PIL import Image

# Contenido del QR (puede ser una URL, texto, etc.)
data = "https://www.youtube.com/watch?v=bkPb-v8vrOU"

# Crea un objeto QRCode
qr = qrcode.QRCode(
    version=1,
    error_correction=qrcode.constants.ERROR_CORRECT_L,
    box_size=10,
    border=4,
)

# Agrega los datos al objeto QRCode
qr.add_data(data)
qr.make(fit=True)

# Crea una imagen del código QR
img = qr.make_image(fill_color="black", back_color="white")

# Guarda la imagen en un archivo PNG
try:
    img.save("codigo_qr.png")
    print("La imagen se ha guardado correctamente.")
except Exception as e:
    print("Error al guardar la imagen:", e)


# Muestra la imagen en una ventana emergente
img.show()
