from django.db import models
# Create your models here.
class UserPtit(models.Model):
    email = models.CharField(max_length=50)
    username = models.CharField(max_length=50)
    password = models.CharField(max_length=50)
    student_id = models.CharField(max_length=50)
    address = models.CharField(max_length=50)

    def __str__(self):
        return f'Email: {self.email}, Username: {self.username}, Password: {self.password}, Student ID: {self.student_id},address:{self.address}'