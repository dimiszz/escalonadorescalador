import pandas as pd
import matplotlib.pyplot as plt

data = pd.read_csv("out.csv")

print(data)

# cutuvelo

plt.scatter(data, x='QUANTUMS',y='MEDIA_INSTRUCOES')

plt.show()