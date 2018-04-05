import numpy as np
from sklearn import svm
from sklearn.metrics import accuracy_score

C=1.0
f = open("ddd.txt")
f.readline() 
data = np.loadtxt(f)

X = data[:, 0:47292]
y = data[:, 47293] 

svc =svm.SVC(kernel='linear',C=C).fit(X,y)
lin_svc =svm.LinearSVC(C=C).fit(X,y)

res= svc.predict(X)
print accuracy_score(y,res)*100
