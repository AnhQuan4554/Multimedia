
from django.shortcuts import render
from .models import UserPtit
from django.contrib.auth.hashers import make_password
from cryptography.fernet import Fernet
import hashlib
from Crypto.Cipher import AES
import base64
from django.http import HttpResponseRedirect
from django.shortcuts import redirect
# Create your views here.
def home(request):
        return render(request, 'pages/index.html')


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
    if request.method == 'POST':
        email = request.POST.get('email')
        username = request.POST.get('username')
        password = request.POST.get('password')
        student_id = request.POST.get('student_id')
        address = request.POST.get('address')
       
        # Mã hóa băm mật khẩu trước khi lưu vào cơ sở dữ liệu
        hashed_password = hashlib.sha256(password.encode()).hexdigest()
       
        # Tạo một đối tượng UserProfile mới và lưu vào cơ sở dữ liệu
        user_profile = UserPtit(email=email, username=username, password=hashed_password, student_id=student_id,address=address)
        user_profile.save()
        
        # return render(request, 'pages/signin.html')
        return redirect('signin')
    else:
        # Nếu không phải method POST thì trả về trang login
        return render(request, 'pages/register.html')
    

def signin(request):
    if request.method == 'POST':
        username = request.POST.get('username')
        password = request.POST.get('password')
        hashed_password = hashlib.sha256(password.encode()).hexdigest()
        print("hased",hashed_password)
        user_profile = UserPtit.objects.filter(username=username).first()
        print("password trong co so du lieu",user_profile.password)
        if user_profile and user_profile.password == hashed_password :
            
            decrypted_student_id = decrypt_data(user_profile.student_id)
            decrypted_student_id = decrypted_student_id[:10]
            user_profile.student_id = decrypted_student_id
            context = {'inforDetail': user_profile}
            print("sau khi giai ma",user_profile.student_id)
            return render(request, 'pages/inforuser.html', context)
        else:
            return render(request, 'pages/signin.html')
        # if hashed_password == user_profile.password: 
        #     return render(request, 'pages/inforuser.html', context)
        # else:
        #     return render(request, 'pages/sigin.html', {'error': 'Email or password is incorrect.'})

    return render(request, 'pages/signin.html')

   

def inforUser(request):
    if request.method == 'POST':
        # email = request.POST.get('email')
        username = request.POST.get('username')
        password = request.POST.get('password')
        print(username)
    return render(request,'pages/inforUser.html')
def listUser(request):
    Data = {'listUserData': UserPtit.objects.all()}
    return render(request, 'pages/listuser.html',Data)
def multimedia(request):
    return redirect ("https://anhquan4554.github.io/Multimedia/")

