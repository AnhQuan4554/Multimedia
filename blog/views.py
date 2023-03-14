from django.shortcuts import render
from .models import Post
# Create your views here.
from django.http import HttpResponse
# Create your views here.
def index(request):
    Data = {'Posts': Post.objects.all().order_by('-date')}
    # print(Data,'okokokoko')
    return render(request, 'pages/blog.html',Data)

def submit(request):
    if request.method == 'POST':
        form = Post()
        # form.save()
        form.title = request.POST.get('title', '')
        title2 = request.POST.get('title2', '')
        form.save()
        # print(form.cleaned_data['username'],'form')
        return render(request, 'pages/blog.html')
        
    else : 
        return render(request, 'pages/blog.html')
