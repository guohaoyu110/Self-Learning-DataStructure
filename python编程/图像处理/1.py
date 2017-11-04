#-*-coding:utf-8-*-

import quandl
import math,datetime
import numpy as np
import pandas as pd
from sklearn import preprocessing,cross_validation,svm
#use cross_validation 去产生我们的训练和测试样例
from sklearn.linear_model import LinearRegression
import matplotlib.pyplot as plt
from matplotlib import style

style.use('ggplot')
df=quandl.get("WIKI/GOOGL")
print(df.head)

#df=quandl.get("FINRA/FNSQ_YRD", authtoken="3v3PCzQhG1pwoPrpfJK3")

# print (df.head())
df =df[['Adj. Open','Adj. High','Adj. Low','Adj. Close','Adj. Volume']]
df['HL_PCT'] = (df['Adj. High']-df['Adj. Close'])/df['Adj. Close']*100.0
df['PCT_change'] = (df['Adj. Close']-df['Adj. Open'])/df['Adj. Close']*100.0
df =df[['Adj. Close', 'HL_PCT', 'PCT_change', 'Adj. Volume']]
#print(df.head())
forecast_col='Adj.Close'
df.fillna(-99999, inplace=True)#当写-1时，会自动计算
forecast_out=int(math.ceil(0.01*len(df)))#根据多大的范围预测
print(forecast_out)

df['label']=df[forecast_col].shift(-forecast_out) #用上次结束时的价格加上变动的幅度
#df.dropna(inplace=True)#inplace=True 不创建新的对象，直接在原始对象上修改
#inplace=False 创建新的对象
#print(df)
X =np.array(df.drop(['label'],1))# return a new dataframe
X=preprocessing.scale(X)

X=X[:-forecast_out]
X_lately=X[-forecast_out:]
df.dropna(inplace=True)


Y=np.array(df['label'])
#X= preprocessing.scale(X)#这个函数用于将给定的数据进行标准化
# 将数据按期属性（按列进行）减去其均值，并处以其方差。得到的结果是，对于每个属性/每列来说所有数据都聚集在0附近，方差为1。

#print(len(X),len(Y))
X_train,X_test,Y_train,Y_test = cross_validation.train_test_split(X,Y,test_size=0.2)
clf=LinearRegression(n_jobs=-1) #clf相当于classifier

#clf=svm.SVR(kernel='poly')

clf.fit(X_train,Y_train)

#clf.score(X_test,Y_test) # 用于classifier的输出

accuracy=clf.score(X_test,Y_test)

forecast_set=clf.predict(X_lately)

print(forecast_set,accuracy,forecast_out)

df['Forecast']=np.nan

last_date = df.iloc[-1].name
last_unix = last_date.timestamp()

one_day = 86400
next_unix=last_unix+one_day

for i in forecast_set:
    next_date=datetime.datetime.fromtimestamp(next_unix)
    next_unix=next_unix+one_day
    df.loc[next_date]=[np.nan for _ in range(len(df.columns)-1)]+[i]
# predict the unknown
df['Adj. Close'].plot()
df['Forecast'].plot()
plt.legend(loc=4)
plt.xlabel('Date')
plt.ylabel('Price')
plt.show()







