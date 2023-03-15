
from django.shortcuts import render
from .models import UserPtit
from django.contrib.auth.hashers import make_password
from cryptography.fernet import Fernet
import hashlib
from Crypto.Cipher import AES
import base64
# Create your views here.
def home(request):
        return render(request, 'pages/index.html')


def signin(request):
    if request.method == 'POST':
        username = request.POST.get('username')
        password = request.POST.get('password')
        print(username,password)
        return render(request, 'pages/sigin.html')
    else:
        # Nếu không phải method POST thì trả về trang login
        return render(request, 'pages/sigin.html')



# Khởi tạo một khóa mã hóa đối xứng
key = Fernet.generate_key()

# Tạo đối tượng mã hóa với khóa vừa khởi tạo
cipher_suite = Fernet(key)
def pad_string(s): # thêm kí tự vào cho đủ chu
    bs = AES.block_size
    return s + (bs - len(s) % bs) * chr(bs - len(s) % bs)
def decrypt_data(encrypted_data):
    key = b'secretkey1234567'
    iv = b'1234567890123456'
    cipher = AES.new(key, AES.MODE_CBC, iv)
    encrypted_data = base64.b64decode(encrypted_data)
    decrypted_data = cipher.decrypt(encrypted_data)
    # Xóa các ký tự rỗng bên phải của chuỗi kết quả
    decrypted_data = decrypted_data.rstrip()
    return decrypted_data.decode('utf-8')


def register(request):
    key = b'secretkey1234567'
    iv = b'1234567890123456'
    cipher = AES.new(key, AES.MODE_CBC, iv)
    if request.method == 'POST':
        email = request.POST.get('email')
        username = request.POST.get('username')
        password = request.POST.get('password')
        student_id = request.POST.get('student_id')

        decrypted_password = decrypt_data(password)
        decrypted_student_id = decrypt_data(student_id)
        decrypted_student_id = decrypted_student_id[:10]
        print("Decrypted password:", decrypted_password)
        print("Decrypted student ID:", decrypted_student_id)
       
        # Mã hóa băm mật khẩu trước khi lưu vào cơ sở dữ liệu
        hashed_password = hashlib.sha256(decrypted_password.encode()).hexdigest()
        print(hashed_password,'has Passs')
        # Tạo một đối tượng UserProfile mới và lưu vào cơ sở dữ liệu
        user_profile = UserPtit(email=email, username=username, password=hashed_password, student_id=decrypted_student_id)
        user_profile.save()
        
        return render(request, 'pages/register.html')
    else:
        # Nếu không phải method POST thì trả về trang login
        return render(request, 'pages/register.html')
def inforUser(request):
    if request.method == 'POST':
        # email = request.POST.get('email')
        username = request.POST.get('username')
        password = request.POST.get('password')
        print(username)
    return render(request,'pages/inforUser.html')