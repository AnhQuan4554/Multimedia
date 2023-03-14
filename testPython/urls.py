"""testPython URL Configuration

The `urlpatterns` list routes URLs to views. For more information please see:
    https://docs.djangoproject.com/en/4.1/topics/http/urls/
Examples:
Function views
    1. Add an import:  from my_app import views
    2. Add a URL to urlpatterns:  path('', views.home, name='home')
Class-based views
    1. Add an import:  from other_app.views import Home
    2. Add a URL to urlpatterns:  path('', Home.as_view(), name='home')
Including another URLconf
    1. Import the include() function: from django.urls import include, path
    2. Add a URL to urlpatterns:  path('blog/', include('blog.urls'))
"""
from django.contrib import admin
from django.urls import path
from blog.views import index
from blog.views import submit
from inforUser.views import signin
from inforUser.views import inforUser
from inforUser.views import register
from inforUser.views import home
urlpatterns = [
    path('submit/',submit,name='submit' ),
    path('inforUser/',inforUser,name='inforUser' ),
    path('signin/',signin,name='signin' ),
    path('register/',register,name='register' ),
    path('admin/', admin.site.urls),
    path('blog/',index,name='blog' ),
    path('',home,name='home' ),
]