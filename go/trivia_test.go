package main

import (
	"testing"
	"os"
	"io/ioutil"
	"log"
)

type fakeRndInter struct {
	counter int
	rnd9    []int
	rnd6    []int
}

func (mri *fakeRndInter) Intn(n int) int {
	var result int
	if n == 5 {
		result = mri.rnd6[mri.counter] - 1
	} else if n == 9 {
		result = mri.rnd9[mri.counter]
		mri.counter++
	} else {
		log.Fatal("Unknown Intn call, got", n)
	}
	return result
}

func TestComplete(t *testing.T) {
	mri := &fakeRndInter{
		0,
		[]int{6, 9, 2, 4, 7, 0, 5, 1, 0, 2, 8, 4, 2, 3, 8, 1, 2, 5, 1, 7, 8, 4, 5, 7, 8, 1, 3, 1, 9, 2, 9, 6, 2, 2, 1, 0, 2, 6, 1, 2, 8, 9, 7, 1, 3, 5, 2, 5, 1, 3},
		[]int{6, 6, 6, 1, 3, 1, 6, 4, 1, 2, 4, 6, 1, 2, 3, 4, 2, 3, 1, 1, 6, 1, 6, 6, 3, 4, 6, 4, 4, 2, 6, 4, 2, 5, 5, 4, 6, 4, 1, 6, 5, 5, 5, 5, 1, 2, 3, 3, 4, 4},
	}
	actual := catchStdOut(t, func() { doMain(mri) })
	expectedBytes, _ := ioutil.ReadFile("../reference/result.txt")
	if string(expectedBytes) != actual {
		t.Fatal(string(expectedBytes))
	}
}

func dieOn(err error, t *testing.T) {
	if err != nil {
		t.Fatal(err)
	}
}

// Returns output to `os.Stdout` from `runnable` as string.
func catchStdOut(t *testing.T, runnable func()) (string) {
	realStdout := os.Stdout
	defer func() { os.Stdout = realStdout }()
	r, fakeStdout, err := os.Pipe()
	dieOn(err, t)
	os.Stdout = fakeStdout
	runnable()
	// need to close here, otherwise ReadAll never gets "EOF".
	dieOn(fakeStdout.Close(), t)
	newOutBytes, err := ioutil.ReadAll(r)
	dieOn(err, t)
	dieOn(r.Close(), t)
	return string(newOutBytes)
}
